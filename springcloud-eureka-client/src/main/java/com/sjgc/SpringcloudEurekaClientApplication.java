package com.sjgc;

import com.sjgc.idleaf.IdLeafService;
import com.sjgc.idleaf.support.IgniteIdLeafServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import java.util.Queue;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.sjgc.mapper")
@ImportResource(locations = {"classpath:idLeaf/applicationContext.xml"})
//@RemoteApplicationEventScan(basePackages = "com.sjgc.event") // 告诉spring cloud bus扫描当前包和子包中的自定义事件
@EnableDiscoveryClient
public class SpringcloudEurekaClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEurekaClientApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @Bean
    IdLeafService igniteIdLeafService() {
        IgniteIdLeafServiceImpl igniteId = new IgniteIdLeafServiceImpl();
        igniteId.setBizTag("order");
        igniteId.setZkAddress("192.168.199.125:2181");
        igniteId.init();
        return igniteId;
    }



}
