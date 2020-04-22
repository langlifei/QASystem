package com.test.vo;

import com.test.entities.Reply;

import java.util.List;

public class Workplace {

    private Integer finishedNumber;
    private Integer unfinishedNumber;
    private List<Reply> recentReply;

    public Integer getFinishedNumber() {
        return finishedNumber;
    }

    public void setFinishedNumber(Integer finishedNumber) {
        this.finishedNumber = finishedNumber;
    }

    public Integer getUnfinishedNumber() {
        return unfinishedNumber;
    }

    public void setUnfinishedNumber(Integer unfinishedNumber) {
        this.unfinishedNumber = unfinishedNumber;
    }

    public List<Reply> getRecentReply() {
        return recentReply;
    }

    public void setRecentReply(List<Reply> recentReply) {
        this.recentReply = recentReply;
    }
}
