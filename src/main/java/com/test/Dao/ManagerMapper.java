package com.test.Dao;

import com.test.Entities.Manager;

public interface ManagerMapper {
    int deleteByPrimaryKey(Integer mID);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(Integer mID);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
}