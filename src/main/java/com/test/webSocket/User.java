package com.test.webSocket;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Zeng Zhuo
 * @Date 2020/5/11 13:36
 * @Describe 单例
 */

public class User extends ClientGroup {

    private User() {
        getWebSockets(this).put("user",new ConcurrentHashMap<>());
    }

    public static User getInstance(){
        return UserHolder.user;
    }

    private static class UserHolder{
        private static User user = new User();
    }

    @Override
    protected void sentMessage() {

    }

    @Override
    protected void receiveMessage() {

    }
}
