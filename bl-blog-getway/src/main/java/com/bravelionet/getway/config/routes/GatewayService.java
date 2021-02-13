package com.bravelionet.getway.config.routes;

import com.bravelionet.getway.hander.GetWayRoutesHander;
import com.bravelionet.getway.hander.RedisRouteDefinitionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.*;

@Service
public class GatewayService implements ApplicationEventPublisherAware, CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(GatewayService.class);
    @Autowired
    private RedisRouteDefinitionRepository routeDefinitionWriter;

    @Autowired
    GetWayRoutesHander getWayRoutesHander;

    private ApplicationEventPublisher publisher;

    public Mono<Object> save() {

        return Mono.fromCallable(() -> {
            return getWayRoutesHander.selectAllRoutes()
                    .flatMap(gatewayRouteList -> {
                        RouteDefinition definition = new RouteDefinition();
                        gatewayRouteList.forEach(gatewayRoute -> {

                            PredicateDefinition predicate = new PredicateDefinition();

                            Map<String, String> predicateParams = new HashMap<>(8);


                            FilterDefinition filterDefinition = new FilterDefinition();

                            Map<String, String> filterParams = new HashMap<>(8);

                            definition.setId(gatewayRoute.getRoutesId());
                            // uri
                            URI uri = UriComponentsBuilder.fromUriString("lb://" + gatewayRoute.getRoutesUri()).build().toUri();

                            predicate.setArgs(predicateParams);

                            filterDefinition.setArgs(filterParams);


                            definition.setPredicates(Arrays.asList(predicate));

                            definition.setFilters(Arrays.asList(filterDefinition));

                            definition.setUri(uri);
                        });
                        return Mono.just(definition);
                    })
                    .flatMap(definition -> {
                        return routeDefinitionWriter.save(Mono.just(definition));
                    })
                    .flatMap(x -> {
                        this.publisher.publishEvent(new RefreshRoutesEvent(this));
                        return Mono.just("success");
                    });

        });
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    @Override
    public void run(String... args) {
        this.save();
    }


    public void deleteRoute(String routeId) {
        routeDefinitionWriter.delete(Mono.just(routeId)).subscribe();
    }
}
