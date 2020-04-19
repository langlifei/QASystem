package com.test.service.imp;

import com.test.dao.UserMapper;
import com.test.entities.User;
import com.test.service.UserService;
import com.test.util.RedisUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;

@Service
public class UserServiceImp implements UserService {

    public final static String KEY_PREFIX="User::";

    @Autowired
    private UserMapper userMapper;

    /**
     * -@Cacheable 当缓存中没有数据时才执行方法主体，并将结果存到缓存。
     *            unless 在方法执行后进行判断条件，为true时不缓存，为false时缓存数据
     * @param username 用户名
     * @return
     */
    @Override
    public User selectOne(String username) {
        //如果存在缓存,取出缓存数据
        if(RedisUtil.hasKey(KEY_PREFIX+username))
            return (User) RedisUtil.get(KEY_PREFIX+username);
        User user = userMapper.selectByUsername(username);
        RedisUtil.set(KEY_PREFIX+user.getUsername(),user, Duration.ofHours(1).getSeconds());
        return user;
    }

    /**
     * -@CachePut  直接执行方法，并将结果存到缓存
     * @param user 用户的基本信息
     * @return
     */
    @Override
    public User insert(User user) {
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
            return user;
        } else
            return null;
    }

    @Override
    public User selectByUserID(Integer userID) {
       return userMapper.selectByPrimaryKey(userID);
    }
}
