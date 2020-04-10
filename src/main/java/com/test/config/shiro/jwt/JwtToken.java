package com.test.config.shiro.jwt;

import com.test.util.JwtUtil;
import org.apache.shiro.authc.AuthenticationToken;

public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(){

    }

    public JwtToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token.replace(JwtUtil.TOKEN_PREFIX,"").trim();
    }

    @Override
    public Object getCredentials() {
        return token.replace(JwtUtil.TOKEN_PREFIX,"").trim();
    }
}
