package com.zpc.myself.study.test.dao;

import com.zpc.myself.study.test.rsp.BookRsp;
import com.zpc.myself.study.test.rsp.ScoreRsp;

import java.util.List;

public interface TestDao {
    Integer selectTest();

    List<BookRsp> selectBookInfo();

    List<ScoreRsp> selectMaxScore();
}
