package com.test.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.entities.User;
import com.test.service.ManagerService;
import com.test.util.JwtUtil;
import com.test.vo.QueryBean;
import com.test.vo.ResponseBean;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    private final Integer pageSize = 10;

    /**
     * 管理根据用户的不同信息条件获取不同的用户群体
     * @return
     */
    @RequiresRoles(value = "admin")
    @GetMapping("/users/{current}")
    public QueryBean getUsers(@PathVariable Integer current, @RequestBody(required = false) User user){
        if(user==null)
            user = new User();
        PageHelper.startPage(current,pageSize);
        List<User> users = managerService.selectAllUser(user);
        PageInfo pageInfo = new PageInfo(users);
        return new QueryBean(pageInfo.getList(), (int) pageInfo.getTotal(),pageSize,pageInfo.getPageNum());
    }

    /**
     * 审核用户
     * @param user 必须传入用户的ID,用户名,用户当前的状态
     * @param request
     * @return 1:{code:200,msg:修改状态成功!,null} 0:{code:400,msg:修改失败!,null}
     */
    @RequiresRoles(value = "admin")
    @PutMapping("/verify")
    public ResponseBean changeUserStatus(@RequestBody User user,HttpServletRequest request){
        String token = JwtUtil.getToken(request);
        String verifier = JwtUtil.getClaim(token,"username");
        user.setVerifier(verifier);
        if(managerService.updateUserStatus(user)!=null)
            return new ResponseBean(HttpStatus.OK.value(),"修改状态成功!",null);
        else
            return new ResponseBean(HttpStatus.BAD_REQUEST.value(),"修改状态失败!",null);
    }
}
