package com.test.webSocket;

import com.test.utils.GsonUtils;
import com.test.vo.Message;
import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/websocket/{username}")
@Component
public class WebSocketServer {

    //静态变量，用来记录当前在线连接数。(如果需要精准统计人数，需要给该变量加锁)
    private static int onlineCount = 0;

    //同步包的线程安全Map,用来存放每个客户端对应的WebSocket对象,即存储每个通信信道。
    private static ConcurrentHashMap<String, WebSocketServer> webSocketMap = new ConcurrentHashMap<>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(@PathParam("username") String username, Session session) {
        this.session = session;
        webSocketMap.put(username,this);
        addOnlineCount();           //在线数加1
        System.out.println("有新窗口开始监听:"+username+",当前在线人数为" + getOnlineCount());
        sendMessage("连接成功");
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketMap.remove(this.session.getId());  //从set中删除
        subOnlineCount();           //在线数减1
        System.out.println(this.session.getId()+"连接关闭！当前在线人数为" + getOnlineCount());
    }
    /**
     * 收到客户端消息后调用的方法
     *
     * @param json 客户端发送过来的json消息串*/
    @OnMessage
    public void onMessage(String json, Session session){
        System.out.println("收到来自窗口"+session.getId()+"的信息:"+json);
        //如果消息不正常,就直接终止。
        if(json.length()==0||json==null||json.trim().equals(""))
            return;
        //反序列化服务端接收到的json消息
        Message msg = GsonUtils.fromJson(json,Message.class);
        //重新设置时间
        msg.setDate(new Date());
        //-1标志为群发
        if(msg.getTo()==null||msg.getTo().equals("-1")||msg.getTo().equals(""))
            //群发
            sendMessageToAll(GsonUtils.toJson(msg));
        else
            //单发
            sendMessageToUser(msg);
    }

    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message){
        try {
            this.session.getBasicRemote().sendText(message);//同步发送消息。
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void sendMessageToUser(Message message){
        //获取到要接受消息的用户的通信信道
        WebSocketServer webSocketServer = webSocketMap.get(message.getTo());
        if (webSocketServer!=null&&webSocketServer.session.isOpen())
            webSocketServer.sendMessage(GsonUtils.toJson(message));
    }

    private void sendMessageToAll(final String message) {
        //获取所有在线用户的通信信道
        Set<Map.Entry<String, WebSocketServer>> entries = webSocketMap.entrySet();
        for(Map.Entry<String,WebSocketServer> entry:entries){
            final WebSocketServer webSocketServer = entry.getValue();
            //给自己以外的所有在线人员发送消息,判断连接是否仍然打开,有可能正在关闭。。。
            if(webSocketServer!=this&&webSocketServer.session.isOpen()){
                //开启多线程发送消息
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if(webSocketServer.session.isOpen()){
                            webSocketServer.sendMessage(message);
                        }
                    }
                }).start();
            }
        }
    }

    /**
     * 群发自定义消息
     * */
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }
    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }
    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}

