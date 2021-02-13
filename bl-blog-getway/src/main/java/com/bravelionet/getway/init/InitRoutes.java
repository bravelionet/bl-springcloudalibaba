package com.bravelionet.getway.init;

import com.bravelionet.common.constant.redis.manageview.RoutesRedisKeyConstant;
import com.bravelionet.common.response.TypicalRep;
import com.bravelionet.common.utils.ObjectMapperUtils;
import com.bravelionet.feign.client.manageview.InitRoutesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author : Lionet
 * @Date : 2021/2/8  17:51
 * @Description : 
 */
@Component
public class InitRoutes implements CommandLineRunner {

    InitRoutesClient initRoutesClient;
    ReactiveRedisTemplate<String, String> reactiveRedisTemplate;

    public InitRoutes(InitRoutesClient initRoutesClient, ReactiveRedisTemplate<String, String> reactiveRedisTemplate) {
        this.initRoutesClient = initRoutesClient;
        this.reactiveRedisTemplate = reactiveRedisTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        TypicalRep<Object> objectTypicalRep = initRoutesClient.selectAll();
        System.out.println("ObjectMapperUtils.jsonEncode(objectTypicalRep) = " + ObjectMapperUtils.jsonEncode(objectTypicalRep));
        reactiveRedisTemplate.opsForHash().put(RoutesRedisKeyConstant.GATEWAY_ROUTES, "id", objectTypicalRep).subscribe();

    }

}
