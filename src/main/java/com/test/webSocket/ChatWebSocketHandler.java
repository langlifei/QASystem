package com.test.webSocket;

import com.test.entities.User;
import com.test.util.GsonUtils;
import com.test.vo.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component("chatWebSocketHandler")
public class ChatWebSocketHandler implements WebSocketHandler {

    //静态变量，用来记录当前在线连接数。(如果需要精准统计人数，需要给该变量加锁)
    private static int onlineCount = 0;

    //同步包的线程安全Map,用来存放每个客户端对应的WebSocket对象,即存储每个通信信道。
    private static ConcurrentHashMap<String,WebSocketSession> webSocketMap = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        //将当前的连接的用户会话放入map集中,key为用户ID
        //获取当前session中存入的用户信息，将当前用户的通信信道存入map中
        User loginUser = (User) webSocketSession.getAttributes().get("loginUser");
        webSocketMap.put(loginUser.getUsername(),webSocketSession);
        //群发消息告知大家。
        Message msg = new Message();
        msg.setText(loginUser.getUsername()+"上线了！");
        msg.setDate(new Date());
        Set<Map.Entry<String, WebSocketSession>> entries = webSocketMap.entrySet();
//        for(Map.Entry<String,WebSocketSession> entry:entries);
////            msg.getList().add((User)entry.getValue().getAttributes().get("loginUser"));//将每个在线的用户添加到要发送的列表中。
//        //将消息转换为json；
//        TextMessage message = new TextMessage(GsonUtils.toJson(msg));
//        sendMessageToAll(message);
    }

    private void sendMessageToAll(final TextMessage message) {
        //获取所有在线用户的通信信道
        Set<Map.Entry<String, WebSocketSession>> entries = webSocketMap.entrySet();
        for(Map.Entry<String,WebSocketSession> entry:entries){
            final WebSocketSession webSocketSession = entry.getValue();
            //判断连接是否仍然打开,有可能正在关闭。。。
            if(webSocketSession.isOpen()){
                //开启多线程发送消息
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if(webSocketSession.isOpen()){
                            try {
                                webSocketSession.sendMessage(message);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        }
    }

    /**
     * 处理客户端向服务端发送的消息。
     * @param webSocketSession
     * @param webSocketMessage
     * @throws Exception
     */
    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        //如果是空消息则不继续处理
        if(webSocketMessage.getPayloadLength()==0)
            return;
        //反序列化服务端接收到的json消息
        Message msg = GsonUtils.fromJson(webSocketMessage.getPayload().toString(),Message.class);
        //重新设置时间
        msg.setDate(new Date());
        String text = msg.getText();
        //为了避免特殊字符存入数据库会发生转义，故使用HTMLUtils.htmlEscape进行转换
        String htmlEscapeText = HtmlUtils.htmlEscape(text);
        msg.setText(htmlEscapeText);
        System.out.println("消息(后期当历史记录存入数据库)"+webSocketMessage.getPayload().toString());
        if(msg.getTo()==null||msg.getTo().equals("-1"))
            //群发
            sendMessageToAll(new TextMessage(GsonUtils.toJson(msg)));
        else
            //单发
            sendMessageToUser(msg.getTo(),new TextMessage(GsonUtils.toJson(msg)));
    }

    private void sendMessageToUser(String id, TextMessage textMessage) throws IOException {
        //获取到要接受消息的用户的通信信道
        WebSocketSession webSocketSession = webSocketMap.get(id);
        if (webSocketSession!=null&&webSocketSession.isOpen())
            webSocketSession.sendMessage(textMessage);
    }

    /*
        如果在传输过程中出现异常处理函数则调用该函数来处理错误
     */
    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        //打印消息
        System.out.println("WebSocket异常断开："+webSocketSession.getId()+"已经关闭");
        //出现通信异常强行关闭连接，节省服务器资源
        if(webSocketSession.isOpen())
            webSocketSession.close();
        //发送消息告知
        Message msg = new Message();
        msg.setDate(new Date());
        //获取异常的用户
        User loginUser = (User) webSocketSession.getAttributes().get("loginUser");
        //在通信信道集中对该用户的信道进行移除
        Set<Map.Entry<String, WebSocketSession>> entries = webSocketMap.entrySet();
        for(Map.Entry<String,WebSocketSession> entry:entries){
            if(entry.getKey().equals(loginUser.getUserID())){
                msg.setText("用户ID："+loginUser.getUserID()+"异常退出");
                webSocketMap.remove(loginUser.getUserID());
                //将其在消息列表中移除
//                msg.getList().remove(loginUser);
                System.out.println("用户ID："+loginUser.getUserID()+"的通信信道异常退出");
                break;
            }
        }
        TextMessage message = new TextMessage(GsonUtils.toJson(msg));
        sendMessageToAll(message);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        //关闭连接
        System.out.println("WebSocket正常断开："+webSocketSession.getId()+"已经关闭");

    }

    /*
    //是否支持部分消息：如果设置为true，那么一个大的或未知尺寸的消息将会被分割，并会收到多次消息（会通过多次调用方法handleMessage(WebSocketSession, WebSocketMessage). ）
	//如果分为多条消息，那么可以通过一个api：org.springframework.web.socket.WebSocketMessage.isLast() 是否是某条消息的最后一部分。
	//默认一般为false，消息不分割
     */
    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
