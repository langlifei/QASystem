package com.test.service;

import com.test.entities.Reply;
import com.test.entities.WorkRecord;
import com.test.vo.WorkRecordDetail;

import java.util.List;

public interface WorkRecordService {

    public boolean insert(WorkRecord workRecord);
    public List<WorkRecord> getAllRecordsByUserID(Integer userID);
    boolean updateWorkRecord(WorkRecord workRecord);
    boolean insertReply(Reply reply);
    WorkRecord selectByWID(Integer wID);
    WorkRecordDetail getWorkRecordDetail(Integer wID);
}
