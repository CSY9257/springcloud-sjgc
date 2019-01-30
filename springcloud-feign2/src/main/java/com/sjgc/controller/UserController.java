package com.sjgc.controller;

import com.sjgc.service.UserServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//这里面的属性有可能会更新的，git中的配置中心变化的话就要刷新，没有这个注解内，配置就不能及时更新
@RefreshScope
public class UserController {

    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    UserServiceApi userService;

    @GetMapping(value = "/queryUser2")
    public String sayHi(@RequestParam String name) {
        return userService.sayHiFromClientOne(name);
    }


    @Value("${name}")
    private String name;
    @Value("${age}")
    private Integer age;

    @RequestMapping("/test")
    public String test(){
        return this.name+this.age;
    }
}
