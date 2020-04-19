package com.test.service;

import com.test.entities.User;

public interface UserService {

    public User selectOne(String username);

    public User insert(User user);

    public User selectByUserID(Integer userID);
}
