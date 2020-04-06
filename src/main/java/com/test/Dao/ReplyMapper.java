package com.test.Dao;

import com.test.Entities.Reply;

public interface ReplyMapper {
    int deleteByPrimaryKey(Integer rID);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer rID);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);
}