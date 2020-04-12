package com.test.dao;

import com.test.entities.WorkRecord;

import java.util.List;

public interface WorkRecordMapper {
    int deleteByPrimaryKey(Integer wID);

    int insert(WorkRecord record);

    int insertSelective(WorkRecord record);

    WorkRecord selectByPrimaryKey(Integer wID);

    int updateByPrimaryKeySelective(WorkRecord record);

    int updateByPrimaryKey(WorkRecord record);

    List<WorkRecord> selectByUserID(Integer userID);
}