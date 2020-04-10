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

    @PostMapping("/add")
    public ResponseBean add(@RequestBody User user){
        if(userService.insert(user))
            return new ResponseBean(HttpStatus.OK.value(),"新增用户成功",null);
        else
            return new ResponseBean(HttpStatus.NOT_IMPLEMENTED.value(),"新增用户失败",null);
    }



}
