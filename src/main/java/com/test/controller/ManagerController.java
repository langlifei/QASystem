package com.test.controller;

import com.test.entities.User;
import com.test.service.ManagerService;
import com.test.util.JwtUtil;
import com.test.vo.ResponseBean;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    /**
     * 管理根据用户群体的不同状态信息获取不同的用户群体
     * @param status 状态信息(-1表示管理员,0表示未审核,1表示已审核)
     * @return
     */
    @RequiresRoles(value = "admin")
    @GetMapping("/users/{status}")
    public ResponseBean getUsers(@PathVariable("status") Integer status){
        String msg = "当前用户群体为空";
        int httpStatus = HttpStatus.OK.value();
        List<User> users = null;
        switch (status){
            case -1:
            case 1:
            case 0:
                users = managerService.selectAllUserByStatus(status);
                break;
            default:
                httpStatus = HttpStatus.BAD_REQUEST.value();
                users = null;
                msg = "用户状态信息有误!";
                break;
        }
        if(users!=null)
            msg = "查找成功!";
        return new ResponseBean(httpStatus,msg,users);
    }

    /**
     * 审核用户
     * @param user 必须传入用户的ID,用户当前的状态
     * @param request
     * @return 1:{code:200,msg:修改状态成功!,null} 0:{code:400,msg:修改失败!,null}
     */
    @RequiresRoles(value = "admin")
    @PutMapping("/verify")
    public ResponseBean changeUserStatus(@RequestBody User user,HttpServletRequest request){
        String token = request.getHeader(JwtUtil.TOKEN_HEADER).replace(JwtUtil.TOKEN_PREFIX,"").trim();
        String verifier = JwtUtil.getClaim(token,"username");
        if(managerService.updateUserStatus(user.getUserID(),user.getStatus(),verifier))
            return new ResponseBean(HttpStatus.OK.value(),"修改状态成功!",null);
        else
            return new ResponseBean(HttpStatus.BAD_REQUEST.value(),"修改失败!",null);
    }
}
