package com.zpc.myself.study.common.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient redissonClient(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        // 设置看门狗最大延长锁时间，默认是30秒
//        config.setLockWatchdogTimeout(30000);
        return Redisson.create(config);
    }
}