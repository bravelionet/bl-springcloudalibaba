package com.bravelionet.dispatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages={"com.bravelionet.feign.client"})
public class BlBlogDispatchApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlBlogDispatchApplication.class,args);
    }
}
