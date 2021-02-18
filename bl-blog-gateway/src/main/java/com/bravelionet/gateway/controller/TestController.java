package com.bravelionet.gateway.controller;

import com.bravelionet.gateway.config.properties.SkipAuthUrlsProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;


@RestController
@RequestMapping("/test")
public class TestController {

   // @Autowired
//    InitRouteService initRouteService;

    @Autowired
    SkipAuthUrlsProperties skipAuthUrlsProperties;
    @GetMapping("/test")
    public Mono<Object> test() throws Exception {
       return   Mono.defer(()->{
              List<String> skipAuthUrls = skipAuthUrlsProperties.getSkipAuthUrls();
              return Mono.just(skipAuthUrls);
          });

    }
}
