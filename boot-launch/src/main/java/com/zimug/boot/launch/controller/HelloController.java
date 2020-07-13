package com.zimug.boot.launch.controller;

import com.zimug.boot.launch.model.LombokPOJO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(String name) {
        return "hello world111, " +name;
    }
//    LombokPOJO lombokPOJO = new LombokPOJO(name, age);

}