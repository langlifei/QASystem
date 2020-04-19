package com.test.controller;

import com.test.entities.User;
import com.test.service.UserService;
import com.test.util.JwtUtil;
import com.test.util.RedisUtil;
import com.test.vo.ResponseBean;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param user 必须传入用户名和密码
     * @param httpServletResponse
     * @return 1:{code:200,msg:登录成功,null} 0:{code:400,msg:用户密码错误,null}
     */
    @PostMapping("/login")
    public ResponseBean login(@RequestBody User user, HttpServletResponse httpServletResponse){
        User userInfo = userService.selectOne(user.getUsername());
        if(userInfo == null)
            return new ResponseBean(HttpStatus.SERVICE_UNAVAILABLE.value(),"该用户名不存在!",null);
        //因为账户使用了用户名+密码的加密形式
        //故对密码使用md5算法进行加密,并使用用户名作为盐值,加密次数为1024次
        String key = new Md5Hash(user.getPassword(), ByteSource.Util.bytes(user.getUsername()),1024).toString();
        if(key.equals(userInfo.getPassword())){
            //存储信息到token
            Map<String,String> map = new HashMap<>();
            map.put("userID",userInfo.getUserID()+"");
            map.put("username",userInfo.getUsername());
            //进行签名
            String token = JwtUtil.sign(map);
            RedisUtil.set(JwtUtil.getRefreshToken()+user.getUsername(),token,JwtUtil.getRefreshTokenExpiration());
            //将用户信息存入缓存
            RedisUtil.set("User::"+userInfo.getUsername(),userInfo, Duration.ofHours(1).getSeconds());
            httpServletResponse.setHeader(JwtUtil.TOKEN_HEADER,token);
            return new ResponseBean(HttpStatus.OK.value(),"登录成功!",null);
        }else
            return new ResponseBean(HttpStatus.BAD_REQUEST.value(),"用户密码错误...",null);
    }
}
