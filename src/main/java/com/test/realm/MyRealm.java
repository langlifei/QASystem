package com.test.realm;

import com.test.config.shiro.jwt.JwtToken;
import com.test.entities.User;
import com.test.service.UserService;
import com.test.util.JwtUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 大坑，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof JwtToken;
    }


   //用于权限管理
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        String userID = JwtUtil.getClaim(principalCollection.toString(),"userID");
        //获取用户的角色
        String role = userService.getRole(Integer.parseInt(userID));
        simpleAuthorizationInfo.addRole(role);
        return simpleAuthorizationInfo;
    }

    //用于用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        //解密获得username,查看信息是否正确
        String username = JwtUtil.getClaim(token,"username");
        if(username==null||username.trim().equals("")){
            throw new AuthenticationException("Token中用户信息有误");
        }
        //查询用户是否存在
        User user = userService.selectOne(username);
        if(user==null){
            throw new AuthenticationException("该用户信息不存在!");
        }
        //认证token
        try {
            if(JwtUtil.verifyToken(token)){
                return new SimpleAuthenticationInfo(token,token,getName());
            }
        }catch (AuthenticationException e){
            throw e;
        }
        throw new AuthenticationException("Token被更改或过期!");
    }
}
