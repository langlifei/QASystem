package com.test.service.imp;
import com.test.service.ManagerService;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImp implements ManagerService {

    @Autowired
    RedisTemplate redisTemplate;

}
