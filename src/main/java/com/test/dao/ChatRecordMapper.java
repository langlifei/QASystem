package com.test.dao;

import com.test.entities.ChatRecord;

public interface ChatRecordMapper {
    int deleteByPrimaryKey(Integer rID);

    int insert(ChatRecord record);

    int insertSelective(ChatRecord record);

    ChatRecord selectByPrimaryKey(Integer rID);

    int updateByPrimaryKeySelective(ChatRecord record);

    int updateByPrimaryKey(ChatRecord record);
}