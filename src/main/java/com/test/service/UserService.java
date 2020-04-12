package com.test.service;

import com.test.entities.User;

public interface UserService {

    /**
     * 根据用户名获取用户信息
     * @param username 用户名
     * @return 用户信息
     */
    public User selectOne(String username);

    /**
     *  根据用户信息添加用户到用户表
     * @param user 用户的基本信息
     * @return 是否添加成功
     */
    public boolean insert(User user);

    public String getRole(Integer userID);

    public User selectByUserID(Integer userID);
}
