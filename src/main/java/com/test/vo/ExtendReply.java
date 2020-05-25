package com.test.vo;

import com.test.entities.Reply;
import org.springframework.data.redis.core.index.PathBasedRedisIndexDefinition;

/**
 * @Author Zeng Zhuo
 * @Date 2020/5/21 10:36
 * @Describe
 */

public class ExtendReply extends Reply {
    private String username;
    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
