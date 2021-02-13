package com.bravelionet.getway.hander;

import com.bravelionet.common.constant.redis.manageview.RoutesRedisKeyConstant;
import com.bravelionet.common.utils.ObjectMapperUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @Author : Lionet
 * @Date : 2021/2/8  16:34
 * @Description : 配置动态路由
 */
@Component
public class RedisRouteDefinitionRepository implements RouteDefinitionRepository {
    // todo 提取常量


    private ReactiveRedisTemplate<String, String> reactiveRedisTemplate;

    private ObjectMapper objectMapper;

    public RedisRouteDefinitionRepository(ReactiveRedisTemplate<String, String> reactiveRedisTemplate, ObjectMapper objectMapper) {
        this.reactiveRedisTemplate = reactiveRedisTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {

        return reactiveRedisTemplate
                .opsForHash()
                .values(RoutesRedisKeyConstant.GATEWAY_ROUTES)
                .flatMap(routeDefinitionX -> {
                    RouteDefinition routeDefinition = objectMapper.convertValue(routeDefinitionX, RouteDefinition.class);
                    return Mono.just(routeDefinition);
                });
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return route
                .flatMap(routeDefinition -> {
                    reactiveRedisTemplate.opsForHash().put(RoutesRedisKeyConstant.GATEWAY_ROUTES, routeDefinition.getId(),
                            ObjectMapperUtils.jsonEncode(routeDefinition));
                    return Mono.empty();
                });
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return routeId.flatMap(id -> {
            return reactiveRedisTemplate.opsForHash()
                    .hasKey(RoutesRedisKeyConstant.GATEWAY_ROUTES, id)
                    .flatMap(result -> reactiveRedisTemplate.delete(RoutesRedisKeyConstant.GATEWAY_ROUTES, id))
                    .flatMap(result -> {
                        if (Objects.isNull(result) || 0 == result) {
                            return Mono.defer(() -> Mono.error(new NotFoundException("路由文件没有找到: " + routeId)));
                        }
                        return Mono.empty();
                    });
        });


    }

}
