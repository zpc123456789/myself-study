package com.zpc.myself.study.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

@Configuration
public class RedisUtil {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public void setKey(String key, String value) {
        redisTemplate.opsForValue().set(key, value, 10, TimeUnit.SECONDS);
    }

    public String getKey(String key) {
        String s = redisTemplate.opsForValue().get(key);
        return s;
    }
}
