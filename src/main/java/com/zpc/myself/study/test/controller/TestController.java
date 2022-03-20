package com.zpc.myself.study.test.controller;

import com.zpc.myself.study.common.config.ThreadLocalConfig;
import com.zpc.myself.study.common.util.UserUtil;
import com.zpc.myself.study.test.dao.TestDao;
import com.zpc.myself.study.test.rsp.BookRsp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class TestController {


    @Autowired
    private TestDao testDao;

    @Autowired
    private ThreadLocalConfig threadLocalConfig;

    @PostMapping("/application/test")
    public Object read() {
        Integer o = testDao.selectTest();
        log.info("read count is:{}", o);
        List<BookRsp> bookRsps = testDao.selectBookInfo();
        return bookRsps;
    }

    @GetMapping("/threadLocal/test")
    public Object test() {
//        ThreadLocal<UserUtil> userInfo = ThreadLocalConfig.getUserInfo();
//        ThreadLocal<UserUtil> userInfo = threadLocalConfig.getUserInfo();
        UserUtil userInfo = threadLocalConfig.getUserInfoTwo();
        String age = userInfo.getAge();
        String name = userInfo.getName();
//        userInfo.remove();
        return "name: " + name + " age: " + age;
    }


}
