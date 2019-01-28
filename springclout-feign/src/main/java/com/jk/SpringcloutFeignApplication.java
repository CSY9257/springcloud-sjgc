package com.jk;

import com.jk.service.ReceiveService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@EnableBinding(ReceiveService.class)
public class SpringcloutFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloutFeignApplication.class, args);
    }

    //监听消息
    @StreamListener("myInput")
    public void onReceive(byte[] msg) {
        System.out.println("消息者2，接收到的消息：" + new String(msg));
    }
}