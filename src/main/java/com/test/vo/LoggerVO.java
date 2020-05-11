package com.test.vo;

import java.util.List;

/**
 * @Author Zeng Zhuo
 * @Date 2020/5/11 0:08
 * @Describe
 */

public class LoggerVO {

    private String visitor;
    private String ip;
    private String method;
    private String description;
    private List<Object> data;

    public String getVisitor() {
        return visitor;
    }

    public void setVisitor(String visitor) {
        this.visitor = visitor;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}
