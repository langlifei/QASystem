package com.test.service;

import com.test.entities.User;

import java.util.List;

public interface ManagerService {

    User updateUserStatus(User user);

    List<User> selectAllUser(User user);
}
