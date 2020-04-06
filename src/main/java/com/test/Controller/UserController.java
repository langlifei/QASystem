package com.test.Controller;

import com.test.Entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class UserController {

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User loginUser, HttpServletRequest requests){
        HttpSession session = requests.getSession();
        session.setAttribute("loginUser",loginUser);
        System.out.println("新用户诞生了："+loginUser);
        return "mainPage";
    }
}
