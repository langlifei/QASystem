package com.test.controller;

import com.test.entities.Reply;
import com.test.entities.WorkRecord;
import com.test.service.WorkRecordService;
import com.test.util.JwtUtil;
import com.test.vo.ResponseBean;
import com.test.vo.WorkRecordDetail;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/workRecord")
public class WorkRecordController {

    @Autowired
    private WorkRecordService workRecordService;

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
        if(workRecordService.insert(workRecord))
            return new ResponseBean(HttpStatus.OK.value(),"创建工单成功!",null);
        else
            return new ResponseBean(HttpStatus.BAD_REQUEST.value(),"创建工单失败!",null);
    }

    /**
     * 获取用户的所有工单
     * @param request 用于获取用户ID
     * @return
     */

    @RequiresRoles("user")
    @GetMapping("/records")
    public ResponseBean getWorkRecords(HttpServletRequest request){
        String token = JwtUtil.getToken(request);
        Integer userID = Integer.parseInt(JwtUtil.getClaim(token,"userID"));
        List<WorkRecord> workRecords = workRecordService.getAllRecordsByUserID(userID);
        return new ResponseBean(HttpStatus.OK.value(),"查找工单成功!",workRecords);
    }

    /**
     * 关闭工单
     * @param wID 工单ID
     * @return
     */
    @RequiresRoles("user")
    @PutMapping("/shutdown/{wID}")
    public ResponseBean shutdownRecord(@PathVariable("wID") Integer wID){
        WorkRecord workRecord = workRecordService.selectByWID(wID);
        if(workRecord==null)
            return new ResponseBean(HttpStatus.BAD_REQUEST.value(),"输入信息有误!",null);
        workRecord.setStatus(1);
        //status:1表示订单终结.
        if(workRecordService.updateWorkRecord(workRecord))
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
        if(workRecord.getStatus()!=1)
            return  new ResponseBean(HttpStatus.BAD_REQUEST.value(),"工单还未关闭,关闭后再来评价!",null);
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
        if(workRecordService.selectByWID(reply.getwID()).getStatus()==1)
            return new ResponseBean(HttpStatus.CONFLICT.value(),"工单已关闭,不能继续回复!",null);
        String token = JwtUtil.getToken(request);
        Integer userID = Integer.parseInt(JwtUtil.getClaim(token,"userID"));
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
    public ResponseBean showDetail(@PathVariable("wID") Integer wID){
        WorkRecordDetail workRecordDetail = workRecordService.getWorkRecordDetail(wID);
        if (workRecordDetail==null)
            return new ResponseBean(HttpStatus.BAD_REQUEST.value(),"查看工单详情出错!",null);
        else
            return new ResponseBean(HttpStatus.OK.value(),"工单信息已返回!",workRecordDetail);
    }
}
