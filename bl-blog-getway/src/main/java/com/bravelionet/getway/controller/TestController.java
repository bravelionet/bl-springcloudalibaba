package com.bravelionet.getway.controller;

import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping("/test")
public class TestController {

    ReactiveRedisTemplate<String, String> reactiveRedisTemplate;

    public TestController(ReactiveRedisTemplate<String, String> reactiveRedisTemplate) {
        this.reactiveRedisTemplate = reactiveRedisTemplate;
    }

    @GetMapping("/redis")
    public Mono<Object> testRedis() {

        String name1 = Thread.currentThread().getName();
        System.out.println("name1 = " + name1
        );
        return reactiveRedisTemplate.opsForValue().set("str", "testRedis").subscribeOn(Schedulers.newParallel("redis_lionet"))
                .map(e -> {
                    String name = Thread.currentThread().getName();
                    System.out.println("name = " + name);
                    return e;
                });
    }
}
