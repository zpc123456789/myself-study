package com.zpc.myself.study.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


//@RestController
@Controller
public class TestController {

    @GetMapping("/hello/controller")
    public Object test() {
        return "hello myself test";
    }

    @GetMapping("/html")
    public Object test2() {
        return "testOne";
    }

    @GetMapping("/jsp1")
    public ModelAndView jspTest() {
        return new ModelAndView("jspTest");
    }

    @GetMapping("/jsp2")
    public Object jspTest2() {
        return "jspTest";
    }


}
