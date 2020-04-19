package com.test.service.imp;

import com.test.dao.UserMapper;
import com.test.entities.User;
import com.test.service.ManagerService;
import com.test.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class ManagerServiceImp implements ManagerService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectAllUserByStatus(Integer status) {
        return userMapper.selectAllByStatus(status);
    }

    @Override
    public User updateUserStatus(User user) {
        switch (user.getStatus()){
            case 0:
            case 1:
                break;
            default:
                return null;
        }
        if(userMapper.updateByPrimaryKeySelective(user)>0){
            //如果缓存中有该用户信息,对其进行更新.
            if(RedisUtil.hasKey(UserServiceImp.KEY_PREFIX+user.getUsername())){
                User newUser = (User) RedisUtil.get(UserServiceImp.KEY_PREFIX+user.getUsername());
                newUser.setStatus(user.getStatus());
                newUser.setVerifier(user.getVerifier());
                RedisUtil.set(UserServiceImp.KEY_PREFIX+user.getUsername(),newUser, Duration.ofHours(1).getSeconds());
                return user;
            }
        }
        return null;
    }
}
