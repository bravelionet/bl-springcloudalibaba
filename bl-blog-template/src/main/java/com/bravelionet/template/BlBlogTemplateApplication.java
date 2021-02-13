package com.bravelionet.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author : Lionet
 * @Date : 2021/2/8  9:39
 * @Description :
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BlBlogTemplateApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlBlogTemplateApplication.class,args);
    }
}
