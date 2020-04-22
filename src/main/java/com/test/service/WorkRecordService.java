package com.test.service;

import com.test.entities.Reply;
import com.test.entities.WorkRecord;
import com.test.vo.WorkRecordDetail;
import com.test.vo.Workplace;

import java.util.List;

public interface WorkRecordService {

    WorkRecord insert(WorkRecord workRecord);
    List<WorkRecord> getAllRecords(Integer userID);
    List<WorkRecord> getAllRecords();
    WorkRecord updateWorkRecord(WorkRecord workRecord);
    boolean insertReply(Reply reply);
    WorkRecord selectByWID(Integer wID);
    WorkRecordDetail getWorkRecordDetail(Integer wID);
    Workplace getWorkplaceInfo(String username);
}
