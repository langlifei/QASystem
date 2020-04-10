package com.test.entities;

import java.util.Date;

public class Reply {
    private Integer rID;

    private String content;

    private Date replyTime;

    private Integer wID;

    private Integer mID;

    public Integer getrID() {
        return rID;
    }

    public void setrID(Integer rID) {
        this.rID = rID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public Integer getwID() {
        return wID;
    }

    public void setwID(Integer wID) {
        this.wID = wID;
    }

    public Integer getmID() {
        return mID;
    }

    public void setmID(Integer mID) {
        this.mID = mID;
    }
}