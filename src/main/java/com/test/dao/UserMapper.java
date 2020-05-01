package com.test.dao;

import com.test.entities.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userID);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userID);

    User selectByUsername(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectAll(User user);
}