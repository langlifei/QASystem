package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * demo
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/4/19 20:36
 */
@Controller
public class AntDesignController {
    @RequestMapping(value = {
            "/",
            "/user",
            "/user/**",
            "/console",
            "/console/**"
    })

    public String forwardIndex() {
        return "index";
    }
}
