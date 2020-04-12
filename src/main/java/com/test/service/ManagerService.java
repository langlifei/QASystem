package com.test.service;

import com.test.entities.User;

import java.util.List;

public interface ManagerService {

    List<User> selectAllUserByStatus(Integer status);

    boolean updateUserStatus(Integer userID, Integer status,String verifier);
}
