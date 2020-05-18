package com.test.webSocket;

import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Zeng Zhuo
 * @Date 2020/5/11 12:26
 * @Describe
 */

public abstract class ClientGroup {
    private final ConcurrentHashMap<String, ConcurrentHashMap<Integer,WebSocket>> webSockets = new ConcurrentHashMap<>(); ;

    public ConcurrentHashMap<String, ConcurrentHashMap<Integer, WebSocket>> getWebSockets(Object obj) {
        if(obj instanceof WebSocket){
            return webSockets;
        }
        return webSockets;
    }

    protected abstract void sentMessage();

    protected abstract void receiveMessage();
}
