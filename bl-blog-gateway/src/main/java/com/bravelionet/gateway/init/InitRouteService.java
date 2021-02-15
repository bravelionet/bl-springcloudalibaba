package com.bravelionet.gateway.init;

import org.springframework.context.annotation.Configuration;

/**
 * @Author : Lionet
 * @Date : 2021/2/8  17:51
 * @Description : 
 */

@Configuration
public class InitRouteService  {
/*

    private static final Logger logger = LoggerFactory.getLogger(InitRouteService.class);

    GateWayRoutesHander getWayRoutesHander;

    ReactiveRedisOperations<String, Object> reactiveRedisOperations;

    public InitRouteService(ReactiveRedisOperations reactiveRedisOperations, GateWayRoutesHander getWayRoutesHander) {
        this.reactiveRedisOperations = reactiveRedisOperations;
        this.getWayRoutesHander = getWayRoutesHander;
    }

    @Override
    public void run(String... args) {
       // getWayRoutesHander.hander();

    }




*/










    /*

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
                }).subscribe();*/
    /*
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
                }).subscribe();


}
     */
}
