package com.bravelionet.dispatch.config.caffiene;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;


public class CaffeineBuilder {

    public static Cache<String, Object> cache(int duration) {
        return cache(128, Context.CAFFEINE_SIZE, duration);
    }


    public static Cache<String, Object> cache() {
        return cache(128, Context.CAFFEINE_SIZE, 600000);
    }

    /**
     *
     *  构建所有来的要缓存的key getCache
     * @param
     * @return
     * @author : Lionet
     * @date : 2021/2/7  15:26
     */
    public static Cache<String, Object> cache(int minSize, int maxSize, int expireSeconds) {
        return Caffeine.newBuilder()
                //初始大小
                .initialCapacity(minSize)
                //最大数量
                .maximumSize(maxSize)
                //过期时间
                .expireAfterWrite(expireSeconds, TimeUnit.SECONDS)
                .build();
    }

}
