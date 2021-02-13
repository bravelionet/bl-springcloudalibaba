package com.bravelionet.getway.config.redis;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Author : Lionet
 * @Date : 2021/2/8  14:36
 * @Description : 动态配置 redis
 */
@Configuration
public class RedisGlobalProperties {


    /**
     * 将 redis  实现配置中心化
     * todo 不建议动态刷线   @RefreshScope  redis, 测试发现 nacos 存在长轮训错误
     *
     * spring:
     *     redis:
     *         host: localhost
     *         port: 6379
     *         password:
     *         database: 13
     *
     * @author : Lionet
     * @date : 2021/2/8  15:36
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.redis")
    public RedisProperties redisProperties() {
        return new RedisProperties();
    }
}
