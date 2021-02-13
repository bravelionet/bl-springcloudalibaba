package com.bravelionet.getway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages={"com.bravelionet.feign.client.manageview"})
public class BlBlogGetWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlBlogGetWayApplication.class, args);
    }


}
