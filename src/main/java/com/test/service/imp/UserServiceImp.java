package com.test.service.imp;

import com.test.dao.UserMapper;
import com.test.entities.User;
import com.test.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectOne(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public boolean insert(@RequestBody User user) {
        //设置用户创建时间
        Date date = new Date();
        user.setRegisterDate(date);
        //设置状态,0表示客户未认证.
        user.setStatus(0);
        //设置角色为用户
        user.setRole("user");
        //对密码使用md5算法进行加密,并使用用户名作为盐值,以免数据库中出现相同密码,加密次数为1024次.
        String newPassword = new Md5Hash(user.getPassword(), ByteSource.Util.bytes(user.getUsername()),1024).toString();
        //使用加密后的密码
        user.setPassword(newPassword);
        if(userMapper.insertSelective(user)>0){
            return true;
        }
        else
            return false;
    }

    @Override
    public String getRole(Integer userID) {
        return userMapper.selectByPrimaryKey(userID).getRole();
    }
}
