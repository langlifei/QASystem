package com.test.service.imp;
import com.test.dao.UserMapper;
import com.test.entities.User;
import com.test.service.ManagerService;
import com.test.util.RedisUtil;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

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
    public boolean updateUserStatus(Integer userID, Integer status,String verifier) {
        User user = new User();
        user.setUserID(userID);
        switch (status){
            case 0:
            case 1:
                user.setStatus(status);
                break;
            default:
                return false;
        }
        user.setVerifier(verifier);
        if(userMapper.updateByPrimaryKeySelective(user)>0)
            return true;
        else
            return false;
    }
}
