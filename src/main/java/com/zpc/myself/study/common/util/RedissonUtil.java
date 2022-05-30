package com.zpc.myself.study.common.util;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
public class RedissonUtil {

    @Autowired
    private RedissonClient redisson;

    public boolean setLock() {
        RLock anyLock = redisson.getLock("anyLock");
        // anyLock.lock(2, TimeUnit.SECONDS); 直接加锁
        boolean lock = false;
        try {
            // 尝试加锁，最多等待100秒
//            lock = anyLock.tryLock(100, 10, TimeUnit.SECONDS);
            lock = anyLock.tryLock(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("get redisson lock exception", e);
        }
        return lock;
    }

    public void delLock(String lockName) {
        RLock anyLock = redisson.getLock(lockName);
        anyLock.unlock();
    }
}
