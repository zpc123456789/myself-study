package com.zpc.myself.study.test.dao;

import com.zpc.myself.study.test.rsp.BookRsp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestDao {
    Integer selectTest();

    List<BookRsp> selectBookInfo();
}
