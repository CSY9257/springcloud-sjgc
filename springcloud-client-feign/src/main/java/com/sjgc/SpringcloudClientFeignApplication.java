package com.sjgc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudClientFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudClientFeignApplication.class, args);
    }

}

