package com.test.webSocket;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Zeng Zhuo
 * @Date 2020/5/11 13:38
 * @Describe
 */

public class Logger extends ClientGroup {

    public Logger() {
        getWebSockets(this).put("logger",new ConcurrentHashMap<>());
    }

    @Override
    protected void sentMessage() {

    }

    @Override
    protected void receiveMessage() {

    }
}
