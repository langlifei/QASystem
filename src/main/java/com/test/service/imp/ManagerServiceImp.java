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
    public User updateUserStatus(User user) {
        switch (user.getStatus()){
            case 0:
            case 1:
            case 2:
                break;
            default:
                return null;
        }
        User oldUser = userMapper.selectByPrimaryKey(user.getUserID());
        if(oldUser==null){
            return null;
        }
        //修改状态
        oldUser.setStatus(user.getStatus());
        //修改审核人
        oldUser.setVerifier(user.getVerifier());
        if(userMapper.updateByPrimaryKeySelective(oldUser)>0){
            //如果缓存中有该用户信息,对其进行更新.
            if(RedisUtil.hasKey(UserServiceImp.KEY_PREFIX+oldUser.getUsername())){
                RedisUtil.set(UserServiceImp.KEY_PREFIX+oldUser.getUsername(),oldUser, Duration.ofHours(1).getSeconds());
            }
            return oldUser;
        }
        return null;
    }

    @Override
    public List<User> selectAllUser(User user) {
        return userMapper.selectAll(user);
    }
}
