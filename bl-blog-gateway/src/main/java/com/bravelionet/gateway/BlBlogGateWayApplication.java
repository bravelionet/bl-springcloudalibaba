package com.bravelionet.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.bravelionet.feign.client.manageview"})
@ComponentScan(basePackages = {"com.bravelionet"})
public class BlBlogGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlBlogGateWayApplication.class, args);
    }
/*   List<RoutesBean> routesBeans = null;
                    try {
                        routesBeans =  ObjectMapperUtils.jsonDecode(x.toString(), new TypeReference<List<RoutesBean>>() {
                        });
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    }*/

}
