package com.zpc.myself.study.test.controller;

import com.zpc.myself.study.test.dao.TestDao;
import com.zpc.myself.study.test.rsp.BookRsp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class TestController {


    @Autowired
    private TestDao testDao;

    @PostMapping("/application/test")
    public Object read() {
        Integer o = testDao.selectTest();
        log.info("read count is:{}", o);
        List<BookRsp> bookRsps = testDao.selectBookInfo();
        return bookRsps;
    }


}
