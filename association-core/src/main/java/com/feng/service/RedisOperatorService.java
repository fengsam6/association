package com.feng.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by rf on 2019/4/23.
 */

@Component
public class RedisOperatorService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void setValue(String key, String val) {
        redisTemplate.opsForValue().set(key, val);
    }

    public void setValue(String key, String val, int time) {
        redisTemplate.opsForValue().set(key, val, time, TimeUnit.SECONDS);
    }

    public String getValue(String key) {
       return redisTemplate.opsForValue().get(key);
    }
    public boolean isExists(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 重名名key，如果newKey已经存在，则newKey的原值被覆盖
     *
     * @param oldKey
     * @param newKey
     */
    public void renameKey(String oldKey, String newKey) {
        redisTemplate.rename(oldKey, newKey);
    }


    /**
     * 删除key
     *
     * @param key
     */
    public void deleteKey(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 删除多个key
     *
     * @param keys
     */
    public void deleteKey(String... keys) {
        List<String> keyList = Arrays.asList(keys);
        redisTemplate.delete(keyList);
    }


    /**
     * 设置key的生命周期
     *
     * @param key
     * @param time
     */
    public void expireKey(String key, long time) {
        redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

    /**
     * 指定key在指定的日期过期
     *
     * @param key
     * @param date
     */
    public void expireKeyAt(String key, Date date) {
        redisTemplate.expireAt(key, date);
    }

    /**
     * 查询key的生命周期
     *
     * @param key
     * @param timeUnit
     * @return
     */
    public long getKeyExpire(String key, TimeUnit timeUnit) {
        return redisTemplate.getExpire(key, timeUnit);
    }

    /**
     * 将key设置为永久有效
     *
     * @param key
     */
    public void persistKey(String key) {
        redisTemplate.persist(key);
    }

}
