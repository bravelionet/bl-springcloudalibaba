package com.bravelionet;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.bravelionet.dao")
@EnableDiscoveryClient
public class BlogManageViewApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogManageViewApplication.class,args);
    }
}
