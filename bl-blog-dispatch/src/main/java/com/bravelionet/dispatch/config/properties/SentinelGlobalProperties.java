package com.bravelionet.dispatch.config.properties;

import com.alibaba.cloud.sentinel.SentinelProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Author : Lionet
 * @Date : 2021/2/18  10:13
 * @Description : Sentinel 配置中心
 */
@Configuration
public class SentinelGlobalProperties {


    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.cloud.sentinel")
    public SentinelProperties sentinelProperties(){
       return new SentinelProperties();
    }
}
