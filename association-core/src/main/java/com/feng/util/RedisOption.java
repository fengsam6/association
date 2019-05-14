package com.feng.util;

import lombok.Data;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by rf on 2019/4/23.
 */

@Component
public class RedisOption {

    @Resource
    private  RedisTemplate<String, Object> redisTemplate;
    public boolean set(String key, Object value,long time) {
        try {
            redisTemplate.opsForValue().set(key, value,time, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    public boolean set(String key, Object value) {
       return set(key, value,60*40);
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

    public boolean hasKey(String key) {

        try {

            return redisTemplate.hasKey(key);

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }

    }

    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

}
