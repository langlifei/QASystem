package com.test.service;

import com.test.entities.Reply;
import com.test.entities.WorkRecord;
import com.test.vo.WorkRecordDetail;

import java.util.List;

public interface WorkRecordService {

    public WorkRecord insert(WorkRecord workRecord);
    public List<WorkRecord> getAllRecordsByUserID(Integer userID);
    WorkRecord updateWorkRecord(WorkRecord workRecord);
    boolean insertReply(Reply reply);
    WorkRecord selectByWID(Integer wID);
    WorkRecordDetail getWorkRecordDetail(Integer wID);
}
