package com.jczx.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author 孙文举
 * @description
 * @create 2019-11-28 10:55
 */
@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 设置值
     *
     * @param key
     * @param value
     */
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 取值
     *
     * @param key
     * @return
     */
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 判断key是否存在
     */
    public boolean exitst(String key) {
        return redisTemplate.hasKey(key);
    }


    /**
     * 根据key删除
     */
    public void remove(String key) {
        if (exitst(key)) {
            redisTemplate.delete(key);
        }
    }


}