package com.zpc.myself.study.test.rsp;

import lombok.Data;

@Data
public class BookRsp {
    private Integer id;
    private String name;
    private String author;
    private Double price;
    private Integer sales;
    private Integer stock;
    private String publishing;
}
