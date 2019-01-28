package com.sjgc.controller;

import com.sjgc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/idLeaf")
    public Long getLongId() {
        Long aLong = userService.getLongId();
        return aLong;
    }
}
