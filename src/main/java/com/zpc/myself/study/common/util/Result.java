package com.zpc.myself.study.common.util;

public class Result {

    private boolean success;

    private Integer code;

    private String message;

    private Object data;

    public Result() {

    }


    public Result(Integer code, String message, boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }

    public static Result SUCCESS() {
        return new Result();
    }

    public static Result FAIL() {
        return new Result();
    }

}
