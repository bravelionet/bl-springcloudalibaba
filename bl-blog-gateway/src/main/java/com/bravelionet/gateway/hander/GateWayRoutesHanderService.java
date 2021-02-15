package com.bravelionet.gateway.hander;

import com.bravelionet.common.constant.response.TypicalRepStatus;
import com.bravelionet.common.response.TypicalRep;
import com.bravelionet.common.utils.ObjectMapperUtils;
import com.bravelionet.domain.manageview.RoutesBean;
import com.bravelionet.feign.client.manageview.InitRoutesClient;
import com.fasterxml.jackson.core.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.Objects;

@Service
public class GateWayRoutesHanderService {
    private static final Logger logger = LoggerFactory.getLogger(GateWayRoutesHanderService.class);

    private InitRoutesClient initRoutesClient;


    public GateWayRoutesHanderService(InitRoutesClient initRoutesClient) {
        this.initRoutesClient = initRoutesClient;

    }


    public Flux<RouteDefinition> hander() {

        return Mono.defer(() -> {
            TypicalRep<Object> responseResult = initRoutesClient.selectAll();
            if (TypicalRepStatus.RESPONSE_STATUS_200.equals(responseResult.getCode())) {
                Object resultData = responseResult.getData();
                List<RoutesBean> routesBeans = ObjectMapperUtils.jsonDecode(resultData.toString(), new TypeReference<List<RoutesBean>>() {
                });
                // todo 待优化封装调用结果
                if (Objects.isNull(routesBeans)) {
                    return Mono.error(new RuntimeException());
                }
                logger.info(" [ 查询 Mysql List Routes 结果 : {} ] ", ObjectMapperUtils.jsonEncode(routesBeans));
                return Mono.just(routesBeans);
            }
            logger.error(" [ 查询 Mysql List Routes 失败 ResponseData: {} ]", ObjectMapperUtils.jsonEncode(responseResult));
            return Mono.error(new RuntimeException());
        }).subscribeOn(Schedulers.elastic()).flatMapMany(routesBeans -> this.operRoute(Mono.just(routesBeans))).log();
    }

    private Flux<RouteDefinition> operRoute(Mono<List<RoutesBean>> routeBeanList) {
        return routeBeanList.flatMapMany(this::transition);
    }

    private Flux<RouteDefinition> transition(List<RoutesBean> routesBeanList) {
        Flux<RouteDefinition> routeDefinitionFlux = Flux.fromStream(routesBeanList.parallelStream())
                .flatMap(routesBean -> {
                    RouteDefinition routeDefinition = new RouteDefinition();
                    String routesId = routesBean.getRoutesId();
                    routeDefinition.setId(routesId);
                    return Mono.just(routeDefinition);
                });
        return routeDefinitionFlux;
    }
}
