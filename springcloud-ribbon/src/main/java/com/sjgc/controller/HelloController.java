package com.sjgc.controller;

import com.sjgc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;


    //get  用来查询   post  新增
    @GetMapping(value = "/hi")// 一个组合注解   是@RequestMapping(method = RequestMethod.GET)的缩写
    public String hi(@RequestParam String name) {

        return helloService.hiService(name);
    }

}
