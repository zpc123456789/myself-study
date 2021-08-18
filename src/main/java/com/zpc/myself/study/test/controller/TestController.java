package com.zpc.myself.study.test.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @PostMapping("/hello/controller")
    public Object test() {
        return "hello myself test";
    }
}
