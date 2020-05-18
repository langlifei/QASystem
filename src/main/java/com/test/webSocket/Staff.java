package com.test.webSocket;

import com.test.entities.WorkRecord;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Zeng Zhuo
 * @Date 2020/5/11 13:21
 * @Describe 单例..
 */

public class Staff extends ClientGroup {
    private Staff() {
        getWebSockets(this).put("admin",new ConcurrentHashMap<>());
    }

    public static Staff getInstance(){
        return StaffHolder.staff;
    }

    private static class StaffHolder{
        private static Staff staff= new Staff();
    }

    @Override
    protected void sentMessage() {

    }

    @Override
    protected void receiveMessage() {

    }
}
