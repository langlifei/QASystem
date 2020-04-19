package com.test.controller;

import com.test.entities.User;
import com.test.service.UserService;
import com.test.vo.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册用户
     * @param user 必须传入用户名(必须唯一),用户密码,手机号码
     * @return
     */
    @PostMapping("/add")
    public ResponseBean add(@RequestBody User user){
        if(userService.insert(user)!=null)
            return new ResponseBean(HttpStatus.OK.value(),"新增用户成功!",null);
        else
            return new ResponseBean(HttpStatus.BAD_REQUEST.value(),"新增用户失败!",null);
    }

    /**
     * 根据用户名查看该用户是否存在
     * @param user 用户(只接收用户名)
     * @return
     */
    @GetMapping("/username")
    public ResponseBean isExist(@RequestBody User user){
        if(userService.selectOne(user.getUsername())!=null)
            return new ResponseBean(HttpStatus.BAD_REQUEST.value(),"该用户名已存在!",null);
        else
            return new ResponseBean(HttpStatus.OK.value(),"该用户名可用!",null);
    }

}
