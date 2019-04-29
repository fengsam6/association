package com.feng.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by rf on 2019/4/23.
 */
@Data
public class RedisOption {
    private String userSessionPrefix="userSession:";
    @Autowired
    private  RedisTemplate<String, Object> redisTemplate;
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

}
