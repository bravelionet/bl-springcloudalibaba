package com.bravelionet.gateway.hander;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.InMemoryRouteDefinitionRepository;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Authror Lionet
 * @Date 2021/2/15 20:29
 * @Description todo 待单例
 */
@Configuration
public class GateWayRoutesHander {

    @Autowired
    InMemoryRouteDefinitionRepository inMemoryRouteDefinitionRepository;
    private static final Logger logger = LoggerFactory.getLogger(GateWayRoutesHander.class);
    private GateWayRoutesHanderService gateWayRoutesHanderService;

    public GateWayRoutesHander(GateWayRoutesHanderService gateWayRoutesHanderService) {
        this.gateWayRoutesHanderService = gateWayRoutesHanderService;
    }

    public void hander() {
        gateWayRoutesHanderService.hander()
                .flatMap(x -> inMemoryRouteDefinitionRepository.save(Mono.just(x)))
                .doOnError(error -> logger.error(" [ GetWay 启动初始化 Routes 失败  Error: {} ] ", error))
                //.subscribe();
                .blockFirst();

    }


}
