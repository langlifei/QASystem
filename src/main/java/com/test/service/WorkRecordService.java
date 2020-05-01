package com.test.service;

import com.test.entities.Reply;
import com.test.entities.WorkRecord;
import com.test.vo.WorkRecordDetail;
import com.test.vo.Workplace;

import java.text.ParseException;
import java.util.List;

public interface WorkRecordService {

    WorkRecord insert(WorkRecord workRecord);
    List<WorkRecord> getAllRecords(WorkRecord workRecord) throws ParseException;
    WorkRecord updateWorkRecord(WorkRecord workRecord);
    boolean insertReply(Reply reply);
    WorkRecord selectByWID(Integer wID);
    WorkRecordDetail getWorkRecordDetail(Integer wID,Integer userID);
    Workplace getWorkplaceInfo(String username);
}
