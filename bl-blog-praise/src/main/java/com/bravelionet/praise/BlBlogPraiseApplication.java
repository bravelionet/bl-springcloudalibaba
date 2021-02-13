package com.bravelionet.praise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author : Lionet
 * @Date : 2021/2/8  9:39
 * @Description : 福利处理
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BlBlogPraiseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlBlogPraiseApplication.class,args);
    }
}
