package com.sjgc;

import com.sjgc.service.SendService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableEurekaClient
@RemoteApplicationEventScan(basePackages = "com.example.configclient.event")
@EnableBinding(SendService.class)
public class SpringcloudConfigClient1Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringcloudConfigClient1Application.class).run(args);

    }
}


