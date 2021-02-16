package com.bravelionet.gateway.hander;

import com.bravelionet.common.constant.response.TypicalRepStatus;
import com.bravelionet.common.response.TypicalRep;
import com.bravelionet.common.utils.ObjectMapperUtils;
import com.bravelionet.domain.manageview.RoutesBean;
import com.bravelionet.feign.client.manageview.InitRoutesClient;
import com.fasterxml.jackson.core.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@Service
public class GateWayRoutesHanderService {
    private static final Logger logger = LoggerFactory.getLogger(GateWayRoutesHanderService.class);

    private InitRoutesClient initRoutesClient;


    public GateWayRoutesHanderService(InitRoutesClient initRoutesClient) {
        this.initRoutesClient = initRoutesClient;

    }


    public Flux<RouteDefinition> hander() {

        return Mono.fromCallable(() -> {
            TypicalRep<Object> responseResult = initRoutesClient.selectAll();
            if (TypicalRepStatus.RESPONSE_STATUS_200.equals(responseResult.getCode())) {
                List<RoutesBean> routesBeans = ObjectMapperUtils.getObjectMapper().convertValue(responseResult.getData(), new TypeReference<List<RoutesBean>>() {
                });
                // todo 待优化封装调用结果
                if (Objects.isNull(routesBeans)) {
                    throw new RuntimeException();
                }
                logger.info(" [ 查询 Mysql List Routes 结果 : {} ] ", ObjectMapperUtils.jsonEncode(routesBeans));
                return routesBeans;
            }
            logger.error(" [ 查询 Mysql List Routes 失败 ResponseData: {} ]", ObjectMapperUtils.jsonEncode(responseResult));
            throw new RuntimeException();
        }).flatMapMany(routesBeans -> {
            return this.operRoute(routesBeans);
        }).doOnError(e -> {
            e.fillInStackTrace();
        });
    }

    private Flux<RouteDefinition> operRoute(List<RoutesBean> routeBeanList) {
        return this.transition(routeBeanList);
    }

    private Flux<RouteDefinition> transition(List<RoutesBean> routesBeanList) {
        return Flux.fromIterable(routesBeanList)
                .defaultIfEmpty(new RoutesBean())
                .doOnError(error -> {
                    error.printStackTrace();
                })
                .flatMap(routesBean -> {
                    RouteDefinition routeDefinition = new RouteDefinition();
                    String routesId = routesBean.getRoutesId();
                    routeDefinition.setId(routesId);
                    try {
                        routeDefinition.setUri(new URI(routesBean.getRoutesUri()));
                    } catch (URISyntaxException e) {
                        logger.error("[ 初始化 GateWay URI 失败, Error: {} ] ", e);
                    }
                    String toutesPredicates = routesBean.getToutesPredicates();
                    PredicateDefinition predicateDefinition = new PredicateDefinition();
                    predicateDefinition.setName("Path");
                    Map<String, String> predicateMap = new HashMap<>();
                    predicateMap.put("pattern",toutesPredicates);
                    predicateDefinition.setArgs(predicateMap);
                    routeDefinition.setPredicates(Arrays.asList(predicateDefinition));
                    return Mono.just(routeDefinition);
                });
    }
}
