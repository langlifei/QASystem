package com.test.webSocket;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Component("chatHandshakeInterceptor")
public class ChatHandshakeInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        if (serverHttpRequest instanceof ServletServerHttpRequest){
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) serverHttpRequest;
            HttpSession session = ((ServletServerHttpRequest) serverHttpRequest).getServletRequest().getSession(false);//true为若存在会话，则返回会话，不存在，则创建；false不存在返回null;
            if(session.getAttribute("loginUser")!=null){
                //User loginUser=(User)session.getAttribute("loginUser") ;
                //将用户放入socket处理器的会话(WebSocketSession)中
                //map.put("loginUser", loginUser);
                //System.out.println("Websocket:用户[ID:" + (loginUser.getId() + ",Name:"+loginUser.getUsername()+"]要建立连接"));
            }
        }else{
            //用户没有登录，拒绝聊天
            //握手失败！
            System.out.println("--------------握手已失败...");
            return false;
        }
		System.out.println("--------------握手开始...");
		return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {
        System.out.println("--------------握手成功啦...");
    }
}
