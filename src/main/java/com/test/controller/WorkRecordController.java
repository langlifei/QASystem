package com.test.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.entities.Reply;
import com.test.entities.User;
import com.test.entities.WorkRecord;
import com.test.service.UserService;
import com.test.service.WorkRecordService;
import com.test.util.JwtUtil;
import com.test.vo.QueryBean;
import com.test.vo.ResponseBean;
import com.test.vo.WorkRecordDetail;
import com.test.vo.Workplace;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/workRecord")
public class WorkRecordController {

    @Autowired
    private WorkRecordService workRecordService;

    @Autowired
    private UserService userService;

    private final int PAGE_SIZE = 10;

    /**
     * 新建工单
     * @param workRecord 必须传入question
     * @param request
     * @return
     */
    @RequiresRoles("user")
    @PostMapping("/add")
    public ResponseBean add(@RequestBody WorkRecord workRecord, HttpServletRequest request){
        String token = JwtUtil.getToken(request);
        Integer userID = Integer.parseInt(JwtUtil.getClaim(token,"userID"));
        workRecord.setUserID(userID);
        if(workRecordService.insert(workRecord)!=null)
            return new ResponseBean(HttpStatus.OK.value(),"创建工单成功!",null);
        else
            return new ResponseBean(HttpStatus.BAD_REQUEST.value(),"创建工单失败!",null);
    }

    /**
     * 获取所有工单
     * @param request 用于获取用户ID
     * @return
     */

    @GetMapping("/records/{current}")
    public QueryBean getWorkRecords(@PathVariable(value = "current") Integer currentPage,@RequestBody(required = false) WorkRecord workRecord,HttpServletRequest request) throws ParseException {
        String token = JwtUtil.getToken(request);
        String username = JwtUtil.getClaim(token,"username");
        User user = userService.selectOne(username);
        List<WorkRecord> workRecords = null;
        //如果是管理员查询所有用户.
        if(user.getRole().equals("admin")){
            user.setUserID(0);//0表示管理员查询所有的用户工单信息
        }
        if(workRecord==null)
            workRecord = new WorkRecord();
        workRecord.setUserID(user.getUserID());
        PageHelper.startPage(currentPage,PAGE_SIZE);
        workRecords = workRecordService.getAllRecords(workRecord);
        if(workRecords.size()==0)
            return new QueryBean(null,0,PAGE_SIZE,1);
        PageInfo pageInfo= new PageInfo(workRecords);
        return new QueryBean(pageInfo.getList(), (int) pageInfo.getTotal(),PAGE_SIZE,pageInfo.getPageNum());
    }

    /**
     * 关闭工单
     * @param wID 工单ID
     * @return
     */
    @RequiresRoles("user")
    @PutMapping("/shutdown/{wID}")
    public ResponseBean shutdownRecord(@PathVariable("wID") Integer wID,HttpServletRequest request){
        String  token = JwtUtil.getToken(request);
        int userID = Integer.parseInt(JwtUtil.getClaim(token,"userID"));
        WorkRecord workRecord = workRecordService.selectByWID(wID);
        if(workRecord==null||workRecord.getUserID()!=userID)
            return new ResponseBean(HttpStatus.BAD_REQUEST.value(),"输入信息有误!",null);
        workRecord.setStatus(3);
        if(workRecordService.updateWorkRecord(workRecord)!=null)
            return new ResponseBean(HttpStatus.OK.value(),"工单已关闭!",null);
        else
            return new ResponseBean(HttpStatus.BAD_REQUEST.value(),"工单编号有误!",null);
    }

    /**
     * 评价工单
     * @param workRecord 必须传入wID,comment,level,status
     * @return
     */
    @RequiresRoles("user")
    @PutMapping("/comment")
    public ResponseBean comment(@RequestBody WorkRecord workRecord){
        if(workRecord.getStatus()!=3)
            return  new ResponseBean(HttpStatus.BAD_REQUEST.value(),"工单还未关闭,关闭后再来评价!",null);
        else if(workRecord.getLevel()<1||workRecord.getLevel()>5)
            return  new ResponseBean(HttpStatus.BAD_REQUEST.value(),"评星等级必须在1~5之间",null);
        workRecordService.updateWorkRecord(workRecord);
        return new ResponseBean(HttpStatus.OK.value(),"评价成功!",null);
    }

    /**
     * 对工单进行回复
     * @param reply 必须传入content(转义特殊字符),wID
     * @param request
     * @return 200 回复成功; 400 输入信息有误!; 409 工单关闭,不允许回复
     */
    @PostMapping("/reply")
    public ResponseBean reply(@RequestBody Reply reply,HttpServletRequest request){
        //查看工单是否关闭
        WorkRecord workRecord = workRecordService.selectByWID(reply.getwID());
        String token = JwtUtil.getToken(request);
        Integer userID = Integer.parseInt(JwtUtil.getClaim(token,"userID"));
        //如果当前工单状态是刚创建，且当前回复是客服回的，那么将工单状态改为进行中
        if(workRecord.getStatus()==1&&workRecord.getUserID()!=userID){
            workRecord.setStatus(2);
            workRecordService.updateWorkRecord(workRecord);
        }
        if(workRecord.getStatus()==3)
            return new ResponseBean(HttpStatus.BAD_REQUEST.value(),"工单已关闭,不能继续回复!",null);
        //设置工单回复人
        reply.setUserID(userID);
        if(workRecordService.insertReply(reply))
            return new ResponseBean(HttpStatus.OK.value(),"回复成功!",null);
        else
            return new ResponseBean(HttpStatus.BAD_REQUEST.value(),"输入信息有误!",null);
    }

    /**
     * 查看工单的详细信息
     * @param wID 工单ID
     * @return
     */
    @GetMapping("/detail/{wID}")
    public ResponseBean showDetail(@PathVariable("wID") Integer wID,HttpServletRequest request){
        String token = JwtUtil.getToken(request);
        String username = JwtUtil.getClaim(token,"username");
        WorkRecordDetail workRecordDetail = workRecordService.getWorkRecordDetail(wID,username);
        //status=-1表示异常工单查询...
        if (workRecordDetail.getWorkRecord().getStatus()==-1)
            return new ResponseBean(HttpStatus.BAD_REQUEST.value(),"查看工单详情出错!",null);
        else
            return new ResponseBean(HttpStatus.OK.value(),"工单信息已返回!",workRecordDetail);
    }

    @GetMapping("/workplace")
    public ResponseBean showWorkplace(HttpServletRequest request){
        String token = JwtUtil.getToken(request);
        String username = JwtUtil.getClaim(token,"username");
        Workplace workplace = workRecordService.getWorkplaceInfo(username);
        return new ResponseBean(HttpStatus.OK.value(),"工作台信息已返回",workplace);
    }
}
