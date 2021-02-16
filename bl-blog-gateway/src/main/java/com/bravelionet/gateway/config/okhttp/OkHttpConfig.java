package com.bravelionet.gateway.config.okhttp;

import feign.Feign;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@ConditionalOnClass(Feign.class)
@AutoConfigureBefore(FeignAutoConfiguration.class)
public class OkHttpConfig {

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                //连接超时
                .connectTimeout(1, TimeUnit.SECONDS)
                //读超时
                .readTimeout(1, TimeUnit.SECONDS)
                //写超时
                .writeTimeout(1, TimeUnit.SECONDS)
                //自动重连
                .retryOnConnectionFailure(true)
                .connectionPool(new ConnectionPool(1000, 5L, TimeUnit.MINUTES))
                .build();
    }
}
