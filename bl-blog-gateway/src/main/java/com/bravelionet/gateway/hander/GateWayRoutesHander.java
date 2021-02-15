package com.bravelionet.gateway.hander;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Authror Lionet
 * @Date 2021/2/15 20:29
 * @Description todo 待单例
 */

public class GateWayRoutesHander implements RouteDefinitionRepository {

    private static final Logger logger = LoggerFactory.getLogger(GateWayRoutesHander.class);
    private GateWayRoutesHanderService gateWayRoutesHanderService;

    public GateWayRoutesHander(GateWayRoutesHanderService gateWayRoutesHanderService) {
        this.gateWayRoutesHanderService = gateWayRoutesHanderService;
    }

    @Override
    @Primary
    public Flux<RouteDefinition> getRouteDefinitions() {
        Flux<RouteDefinition> hander = gateWayRoutesHanderService.hander();
        return hander;
    }

  /*  @Primary
    public void hander() {
        Flux<RouteDefinition> hander = gateWayRoutesHanderService.hander();
        hander.flatMap(routeDefinition -> {
            return this.save(Mono.just(routeDefinition));
        }).subscribeOn(Schedulers.elastic()).doOnError(error -> {
            logger.error("[ 初始化  GetWay Routes 失败 Error: {} ]", error);
        }).subscribe();

    }*/

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return null;
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return null;
    }
}
