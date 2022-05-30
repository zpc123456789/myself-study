package com.zpc.myself.study.test.controller;

import com.zpc.myself.study.common.util.RedisUtil;
import com.zpc.myself.study.common.util.RedissonUtil;
import com.zpc.myself.study.test.dao.TestDao;
import com.zpc.myself.study.test.rsp.ScoreRsp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class TransactionalTest {

    @Autowired
    private TestDao testDao;

    @Autowired
    private RedissonUtil redissonUtil;

    @Autowired
    private RedisUtil redisUtil;

    @Transactional
    @PostMapping("trs/testOne")
    public Map<String, Object> TestOne() {
        Map<String, Object> map = new HashMap<>();
        try {
            int a = 2;
            int b = 0;


            log.info("get a/b result", a/b);
            List<ScoreRsp> scoreRsps = testDao.selectMaxScore();
            map.put("map", scoreRsps);
            map.put("a/b", a/b);
        } catch (Exception e) {
            log.error("get some error", e);
            throw e;
        }
        return map;
    }

    @PostMapping("trs/testTwo")
    public Map<String, Object> TestTwo() {
        Map<String, Object> map = new HashMap<>();
        try {
            if (redissonUtil.setLock()) {
                map.put("map", "获取到分布式锁");
            } else {
                List<ScoreRsp> scoreRsps = testDao.selectMaxScore();
                map.put("map", scoreRsps);
            }
        } catch (Exception e) {
            log.error("get some error", e);
        } finally {
//            redissonUtil.delLock("anyLock");
        }
        return map;
    }

    @PostMapping("trs/Three")
    public Map<String, Object> TestThree() {
        Map<String, Object> map = new HashMap<>();
        Object test = redisUtil.getKey("anyLock");
        boolean b = redissonUtil.setLock();
        map.put("test", test);
        map.put("b", b);
        return map;
    }

    @PostMapping("trs/Four")
    public String TestFour() {
        redissonUtil.delLock("anyLock");
        return "do";
    }
}