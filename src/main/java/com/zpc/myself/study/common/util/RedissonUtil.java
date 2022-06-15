package com.zpc.myself.study.common.util;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

@Slf4j
//@Configuration
public class RedissonUtil {

    @Autowired
    private RedissonClient redisson;

    public boolean setLock() {
        RLock anyLock = redisson.getLock("anyLock");
        // anyLock.lock(2, TimeUnit.SECONDS); 直接加锁
        boolean lock = false;
        try {
            // 尝试加锁，最多等待100秒，设置了锁时间5后释放锁
//            lock = anyLock.tryLock(100, 5, TimeUnit.SECONDS);
            // 看门狗机制
            lock = anyLock.tryLock(5, TimeUnit.SECONDS);
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
