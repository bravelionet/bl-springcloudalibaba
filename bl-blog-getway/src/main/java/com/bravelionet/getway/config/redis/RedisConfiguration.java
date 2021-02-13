package com.bravelionet.getway.config.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;

/**
 * @Author : Lionet
 * @Date : 2021/2/8  15:06
 * @Description : redis config
 */
@Configuration
public class RedisConfiguration {


    @Bean
    public ReactiveRedisTemplate<String, String> reactiveRedisTemplate(ReactiveRedisConnectionFactory factory) {

        //todo 指定 配置项
        return new ReactiveRedisTemplate<>(factory, RedisSerializationContext.string());
    }
}
