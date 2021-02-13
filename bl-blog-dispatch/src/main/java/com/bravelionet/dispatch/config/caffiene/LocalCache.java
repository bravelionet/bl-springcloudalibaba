package com.bravelionet.dispatch.config.caffiene;

/**
 * @Author : Lionet
 * @Date : 2021/1/7  15:45
 * @Description : Cache 本地缓存操作接口
 */
public interface LocalCache {

    /**
     * @Author : Lionet
     * @Date : 2021/1/7  15:46
     * @Param : cache key
     * @Description :  根据 Key 获取映射缓存值
     */
    Object get(String key);

    /**
     * @Author : Lionet
     * @Date : 2021/1/7  15:46
     * @Param key : cache key
     * @Param defaultValue : cache defaultValue
     * @Param : key : cache key
     * @Description :  根据 Key 及 默认值 获取映射缓存值
     */
    Object get(String key, Object defaultValue);

    /**
     * @Author : Lionet
     * @Date : 2021/1/7  15:53
     * @Param key : cache key
     * @Description : 删除指定 Key
     */
    void delete(String key);

    /**
     * @Author : Lionet
     * @Date : 2021/1/7  15:54
     * @Param :
     * @Description :
     */
    void set(String key, Object object);

    /**
     * @Author : Lionet
     * @Date : 2021/1/7  15:56
     * @Param :
     * @Description : 删除全部缓存
     */
    void removeAll();

}
