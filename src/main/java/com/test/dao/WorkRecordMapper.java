package com.test.dao;

import com.test.entities.WorkRecord;

public interface WorkRecordMapper {
    int deleteByPrimaryKey(Integer wID);

    int insert(WorkRecord record);

    int insertSelective(WorkRecord record);

    WorkRecord selectByPrimaryKey(Integer wID);

    int updateByPrimaryKeySelective(WorkRecord record);

    int updateByPrimaryKey(WorkRecord record);
}