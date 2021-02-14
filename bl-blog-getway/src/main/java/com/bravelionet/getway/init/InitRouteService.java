package com.bravelionet.getway.init;

import com.bravelionet.common.constant.redis.manageview.RoutesRedisKeyConstant;
import com.bravelionet.common.constant.response.TypicalRepStatus;
import com.bravelionet.common.response.TypicalRep;
import com.bravelionet.common.utils.ObjectMapperUtils;
import com.bravelionet.domain.manageview.RoutesBean;
import com.bravelionet.feign.client.manageview.InitRoutesClient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

/**
 * @Author : Lionet
 * @Date : 2021/2/8  17:51
 * @Description : 
 */
@Component
public class InitRouteService implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(InitRouteService.class);

    @Autowired
    ObjectMapper objectMapper;
    InitRoutesClient initRoutesClient;

    ReactiveRedisOperations<String, Object> reactiveRedisOperations;

    public InitRouteService(InitRoutesClient initRoutesClient, ReactiveRedisOperations reactiveRedisOperations) {
        this.initRoutesClient = initRoutesClient;
        this.reactiveRedisOperations = reactiveRedisOperations;
    }

    /**
     * @Author: Lionet
     * @Date 2021/2/14 22:06
     * @Description 初始化 GetWay RouteList
     * @Param:
     * @Return:
     */
    @Override
    public void run(String... args) throws Exception {
        Mono.fromCallable(() -> {
            TypicalRep<Object> routesList = initRoutesClient.selectAll();
            return routesList;
        }).subscribeOn(Schedulers.elastic())
                .map(routesList -> Optional.ofNullable(routesList))
                .defaultIfEmpty(Optional.empty())
                .onErrorResume(error -> {
                    logger.error(" [ Failed To  Initialize  RequestSelect Mysql GetWay RouteList  Error: {} ] ", error);
                    return Mono.empty();
                })
                .flatMap(routesList -> {
                    if (routesList.isPresent()) {
                        if (TypicalRepStatus.RESPONSE_STATUS_200.equals(routesList.get().getCode())) {
                            List<RoutesBean> routesBeanList = ObjectMapperUtils.getObjectMapper().convertValue(routesList.get().getData(), new TypeReference<List<RoutesBean>>() {
                            });
                            return Flux.fromIterable(routesBeanList)
                                    .flatMap(reouteBean -> {
                                        return reactiveRedisOperations.opsForHash()
                                                .put(RoutesRedisKeyConstant.GATEWAY_ROUTES, reouteBean.getId().toString(), ObjectMapperUtils.jsonEncode(reouteBean))
                                                .map(result -> Optional.ofNullable(result))
                                                .defaultIfEmpty(Optional.empty())
                                                .onErrorResume(error -> {
                                                    logger.error(" [ Failed To Initialize The Push Routes Redis  Error: {} ] ", error);
                                                    return Mono.empty();
                                                })
                                                .flatMap(x -> {
                                                    if (x.isPresent()) {
                                                        if (x.get()) {
                                                            return Mono.just(Boolean.TRUE);
                                                        }
                                                    }
                                                    return Mono.error(RuntimeException::new);
                                                });
                                    })
                                    .collectList();
                        } else {
                            return Mono.error(RuntimeException::new);
                        }

                    } else {
                        return Mono.error(RuntimeException::new);
                    }
                }).subscribe();/*
                .flatMap(x -> {
                    return reactiveRedisOperations.opsForHash().values(RoutesRedisKeyConstant.GATEWAY_ROUTES)
                            .doOnError(erro -> {
                                erro.printStackTrace();
                            })
                            .flatMap(xx -> {
                                System.out.println("xx = " + xx);
                                return Mono.just(xx);
                            }).collectList();
                })
                .flatMap(x -> {
                    List<RoutesBean> routesBeans = null;
                    try {
                        routesBeans =  ObjectMapperUtils.jsonDecode(x.toString(), new TypeReference<List<RoutesBean>>() {
                        });
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    }
                    System.out.println("s = " + routesBeans);
                    return Mono.just(x);
                }).subscribe();*/


    }
}
