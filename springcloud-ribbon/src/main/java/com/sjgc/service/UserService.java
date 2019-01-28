package com.sjgc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private RestTemplate restTemplate;


    public Long getLongId() {
        return restTemplate.getForObject("http://service-config/idLeaf/getLongId", Long.class);
    }



}
