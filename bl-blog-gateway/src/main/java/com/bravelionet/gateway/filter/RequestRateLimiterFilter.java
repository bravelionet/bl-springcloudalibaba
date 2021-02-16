package com.bravelionet.gateway.filter;

public class RequestRateLimiterFilter {

    /**
     * 方式一 :
     *      可使用 GatWay yml 配置
     *        filters:
     *         - name: RequestRateLimiter
     *           args:
     *             key-resolver: '#{@hostAddrKeyResolver}'
     *             redis-rate-limiter.replenishRate: 1
     *             redis-rate-limiter.burstCapacity: 3
     *
     * 方式二 (优先):
     *      因 GateWay 官方使用的 令牌桶算法进行全局限流,
     *      令牌桶 基于 Redis 实现全局限流
     *
     * 方式三 :
     *      漏水算法实现全局限流
     *
     *
     */
}
