package com.test.vo;

import com.test.entities.Reply;
import com.test.entities.WorkRecord;

import java.util.List;

public class WorkRecordDetail {
    private WorkRecord workRecord;
    private List<Reply> replies;

    public WorkRecord getWorkRecord() {
        return workRecord;
    }

    public void setWorkRecord(WorkRecord workRecord) {
        this.workRecord = workRecord;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }
}
