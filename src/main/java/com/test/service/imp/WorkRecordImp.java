package com.test.service.imp;

import com.test.dao.ReplyMapper;
import com.test.dao.WorkRecordMapper;
import com.test.entities.Reply;
import com.test.entities.WorkRecord;
import com.test.service.WorkRecordService;
import com.test.vo.WorkRecordDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
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

    /**
     * status(0表示未结单,1表示已结单)
     * 新增用户的工单记录
     * @param workRecord 工单的信息
     * @return 是否创建成功
     */
    @Override
    public WorkRecord insert(WorkRecord workRecord) {
        workRecord.setUUID(UUID.randomUUID().toString());
        workRecord.setBeginDate(new Date());//将当前时间设置为工单创建时间
        workRecord.setStatus(0);//设置为0
        if(workRecordMapper.insertSelective(workRecord)>0)
            return workRecord;
        else
            return null;
    }

    /**
     * 根据用户ID查找其所有的工单
     * @param userID 用户ID
     * @return 工单集合
     */
    @Override
    public List<WorkRecord> getAllRecordsByUserID(Integer userID) {
        return workRecordMapper.selectByUserID(userID);
    }

    /**
     * 根据工单信息修改工单
     * @param workRecord 工单信息
     * @return 是否修改成功
     */
    @Override
    @CachePut(value = "WorkRecord",key = "#workRecord.wID",unless = "#result==null")
    public WorkRecord updateWorkRecord(WorkRecord workRecord) {
        if(workRecord.getStatus()!=null&&workRecord.getStatus()==1)
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
        return workRecordMapper.selectByPrimaryKey(wID);
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
    public WorkRecordDetail getWorkRecordDetail(Integer wID) {
        WorkRecord workRecord = selectByWID(wID);
        if(workRecord==null)
            return null;
        //将工单内容作为第一条回复信息.
        Reply reply = new Reply();
        reply.setContent(workRecord.getQuestion());
        reply.setReplyTime(workRecord.getBeginDate());
        reply.setUserID(workRecord.getUserID());
        WorkRecordDetail workRecordDetail = new WorkRecordDetail();
        workRecordDetail.setWorkRecord(workRecord);
        List<Reply> replies = new ArrayList<>();
        replies.add(reply);//添加第一条回复信息
        replies.addAll(replyMapper.selectByWID(wID));
        workRecordDetail.setReplies(replies);
        return workRecordDetail;
    }
}
