package com.test.service.imp;

import com.test.dao.ReplyMapper;
import com.test.dao.WorkRecordMapper;
import com.test.entities.Reply;
import com.test.entities.User;
import com.test.entities.WorkRecord;
import com.test.service.UserService;
import com.test.service.WorkRecordService;
import com.test.vo.WorkRecordDetail;
import com.test.vo.Workplace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class WorkRecordImp implements WorkRecordService {

    @Autowired
    private WorkRecordMapper workRecordMapper;

    @Autowired
    private ReplyMapper replyMapper;

    @Autowired
    private UserService userService;

    /**
     * status(0表示逻辑删除,1表示未处理)
     * 新增用户的工单记录
     * @param workRecord 工单的信息
     * @return 是否创建成功
     */
    @Override
    public WorkRecord insert(WorkRecord workRecord) {
        workRecord.setUUID(UUID.randomUUID().toString());
        workRecord.setBeginDate(new Date());//将当前时间设置为工单创建时间
        workRecord.setStatus(1);//设置为1
        if(workRecordMapper.insertSelective(workRecord)>0)
            return workRecord;
        else
            return null;
    }

    /**
     * 根据用户ID查找其所有的工单
     * @param
     * @return 工单集合
     */
    @Override
    public List<WorkRecord> getAllRecords(WorkRecord workRecord) throws ParseException {
//        if(workRecord.getBeginDate()==null)
//            workRecord.setBeginDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019.01.01 00:00:00"));
//        if(workRecord.getEndDate()==null)
//            workRecord.setEndDate(new Date());
        return workRecordMapper.selectAll(workRecord);
    }

    /**
     * 根据工单信息修改工单
     * @param workRecord 工单信息
     * @return 是否修改成功
     */
    @Override
    @CachePut(value = "WorkRecord",key = "#workRecord.wID",unless = "#result==null")
    public WorkRecord updateWorkRecord(WorkRecord workRecord) {
        //工单关闭添加关闭时间....
        if(workRecord.getStatus()!=null&&workRecord.getStatus()==3)
            workRecord.setEndDate(new Date());
        if(workRecordMapper.updateByPrimaryKeySelective(workRecord)>0)
            return workRecord;
        else
            return null;
    }

    /**
     * 根据工单ID查找对应的工单信息
     * @param wID
     * @return
     */
    @Override
    @Cacheable(value = "WorkRecord",key = "#wID",unless = "#result==null")
    public WorkRecord selectByWID(Integer wID) {
        WorkRecord workRecord =  workRecordMapper.selectByPrimaryKey(wID);
        return workRecord;
    }

    /**
     * 对工单进行回复
     * @param reply 回复的信息
     * @return
     */
    @Override
    public boolean insertReply(Reply reply) {
        reply.setReplyTime(new Date());
        if(replyMapper.insert(reply)>0)
            return true;
        else
            return false;
    }

    @Override
    @Cacheable(value = "WorkRecord",key = "'detail'+#wID",unless = "#result.workRecord.status!=3")
    public WorkRecordDetail getWorkRecordDetail(Integer wID,Integer userID) {
        WorkRecordDetail workRecordDetail = new WorkRecordDetail();
        WorkRecord workRecord = new WorkRecord();
        workRecord.setStatus(-1);
        workRecordDetail.setWorkRecord(workRecord);
        workRecord = selectByWID(wID);
        //由于做了缓存不能返回控制,否则会报错,故采用状态为-1做标记值....
        if(workRecord==null || workRecord.getUserID()!=userID)
            return workRecordDetail;
        //将工单内容作为第一条回复信息.
        Reply reply = new Reply();
        reply.setContent(workRecord.getQuestion());
        reply.setReplyTime(workRecord.getBeginDate());
        reply.setUserID(workRecord.getUserID());
        workRecordDetail.setWorkRecord(workRecord);
        List<Reply> replies = new ArrayList<>();
        replies.add(reply);//添加第一条回复信息
        replies.addAll(replyMapper.selectByWID(wID));
        workRecordDetail.setReplies(replies);
        return workRecordDetail;
    }

    @Override
    public Workplace getWorkplaceInfo(String username) {
        Workplace workplace = new Workplace();
        User user = userService.selectOne(username);
        Integer userID = 0;
        if(user.getRole().equals("user"))
            userID = user.getUserID();
        workplace.setFinishedNumber(workRecordMapper.getCountByStatus(userID,3));
        workplace.setUnfinishedNumber(workRecordMapper.getCountByStatus(userID,1)+workRecordMapper.getCountByStatus(userID,2));
        //显示最近七条不同工单的最新回复.
        List list = workRecordMapper.selectTop(7,userID);
        if(list.size()==0){
            workplace.setRecentReply(null);
            return workplace;
        }
        workplace.setRecentReply(replyMapper.selectRecentReplyInWIDs(list,userID));
        return workplace;
    }
}
