package com.test.Entities;

import java.util.Date;

public class ChatRecord {
    private Integer rID;

    private Date rDate;

    private String rPath;

    private Integer status;

    private String comment;

    private Integer level;

    private String enclosure;

    private Integer userID;

    private Integer mID;

    public Integer getrID() {
        return rID;
    }

    public void setrID(Integer rID) {
        this.rID = rID;
    }

    public Date getrDate() {
        return rDate;
    }

    public void setrDate(Date rDate) {
        this.rDate = rDate;
    }

    public String getrPath() {
        return rPath;
    }

    public void setrPath(String rPath) {
        this.rPath = rPath == null ? null : rPath.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure == null ? null : enclosure.trim();
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getmID() {
        return mID;
    }

    public void setmID(Integer mID) {
        this.mID = mID;
    }
}