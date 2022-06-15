package com.zpc.myself.study.easycode.entity;

import lombok.Data;

/**
 * (TPerson)实体类
 *
 * @author makejava
 * @since 2022-06-15 11:43:09
 */
@Data
public class TPerson  {

    /**
     * id
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 班级
     */
    private String clazz;



}

