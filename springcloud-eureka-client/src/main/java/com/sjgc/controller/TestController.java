package com.sjgc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//这里面的属性有可能会更新的，git中的配置中心变化的话就要刷新，没有这个注解内，配置就不能及时更新
@RefreshScope
public class TestController {

    @Value("${server.port}")
    private Integer ip;
    @Value("${spring.application.name}")
    private String  name;

    @RequestMapping("/test")
    public String test() {
        return this.ip + this.name;
    }

   @GetMapping("/test2")
    private String  test2(){
       return "111";
   }


}
