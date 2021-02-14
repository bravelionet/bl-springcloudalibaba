package com.bravelionet.getway.controller;

import com.bravelionet.getway.init.InitRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    InitRouteService initRouteService;

    @GetMapping("/test")
    public Mono<Object> test() throws Exception {
        try {
               initRouteService.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
