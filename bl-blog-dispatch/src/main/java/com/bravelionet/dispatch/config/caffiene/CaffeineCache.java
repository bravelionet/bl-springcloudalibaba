package com.bravelionet.dispatch.config.caffiene;

import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.stereotype.Service;

/**
 * @Author : Lionet
 * @Date : 2021/1/7  15:44
 * @Description : Caffeine 缓存面对 LocalCache 实现
 */
@Service
public class CaffeineCache implements LocalCache {

    private Cache<String, Object> cache;

    public CaffeineCache() {
        this.cache = CaffeineBuilder.cache();
    }

    @Override
    public Object get(String key) {
        return get(key, null);
    }

    @Override
    public Object get(String key, Object defaultValue) {
        Object o = cache.getIfPresent(key);
        if (o == null) {
            return defaultValue;
        }
        return o;
    }

    @Override
    public void delete(String key) {
        cache.invalidate(key);
    }

    @Override
    public void set(String key, Object object) {
        cache.put(key, object);
    }

    @Override
    public void removeAll() {

    }
}
