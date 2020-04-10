package com.test.config.shiro.jwt;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.test.util.GsonUtils;
import com.test.util.JwtUtil;
import com.test.util.RedisUtil;
import com.test.vo.ResponseBean;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@Component
public class JwtFilter extends BasicHttpAuthenticationFilter {

    @Autowired
    private  RedisUtil redisUtil;




    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        //判断请求的请求头是否带上"Token"
        if(((HttpServletRequest)request).getHeader(JwtUtil.TOKEN_HEADER)!=null){
            try {
                executeLogin(request,response);
                return true;
            }catch (Exception e){
                String msg = e.getMessage();
                //认证出现异常,传递错误信息msg
                Throwable throwable = e.getCause();
                if(throwable instanceof SignatureVerificationException){
                    msg = "Token不正确";
                }else if(throwable instanceof TokenExpiredException){
                    //如果是token过期,判断RefreshToken是否过期,未过期返回true
                    if(this.refreshToken(request,response))
                        return true;
                    else
                        msg = "Token已过期,请重新登录";
                }else{
                    if(throwable!=null)
                        msg = throwable.getMessage();
                }
                this.response401(response,msg);
                return false;
            }
        }else{
            this.response401(response,"请先登录!");
            return false;
        }
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        String token = httpServletRequest.getHeader(JwtUtil.TOKEN_HEADER);
        JwtToken jwtToken = new JwtToken(token);
        //提交给realm进行登入
        getSubject(request,response).login(jwtToken);
        return true;
    }

    /**
     * 无需转发，直接返回Response信息
     */
    private void response401(ServletResponse response, String msg){
        HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        try (PrintWriter out = httpServletResponse.getWriter()) {
            String data = GsonUtils.toJson(new ResponseBean(HttpStatus.UNAUTHORIZED.value(), "无权访问(Unauthorized):" + msg, null));
            out.append(data);
        } catch (IOException e) {
            System.out.println("response输出出错!");
        }
    }


    private boolean refreshToken(ServletRequest request, ServletResponse response) {
        // 拿到当前Header中Authorization的AccessToken(Shiro中getAuthzHeader方法已经实现)
        String token = this.getAuthzHeader(request).replace(JwtUtil.TOKEN_PREFIX,"").trim();
        // 获取当前Token的帐号信息
        String username = JwtUtil.getClaim(token,"username");
        String key = JwtUtil.getRefreshToken()+username;
        // 判断Redis中RefreshToken是否存在,并且是否是最新的token.
        if (RedisUtil.hasKey(key)&&RedisUtil.get(key).equals(token)) {
            //从Token中获取userID
            String userID = JwtUtil.getClaim(token,"userID");
            //生成新的token
            Map<String,String> map = new HashMap<>();
            map.put("userID",userID);
            map.put("username",username);
            token = JwtUtil.sign(map);
            RedisUtil.set(key,token,RedisUtil.getExpire(key));
            // 将新刷新的AccessToken再次进行Shiro的登录
            JwtToken jwtToken = new JwtToken(token);
            // 提交给UserRealm进行认证，如果错误他会抛出异常并被捕获，如果没有抛出异常则代表登入成功，返回true
            this.getSubject(request, response).login(jwtToken);
            // 最后将刷新的AccessToken存放在Response的Header中的Authorization字段返回
            HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
            httpServletResponse.setHeader(JwtUtil.TOKEN_HEADER, token);
            return true;
        }
        return false;
    }

}
