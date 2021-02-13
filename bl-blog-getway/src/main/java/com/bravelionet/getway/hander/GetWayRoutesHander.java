package com.bravelionet.getway.hander;

import com.bravelionet.domain.manageview.RoutesBean;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class GetWayRoutesHander {
    public static final String GATEWAY_ROUTES = "gateway:routes";
  private   ReactiveRedisTemplate<String,String> reactiveRedisTemplate;

  public GetWayRoutesHander( ReactiveRedisTemplate<String,String> reactiveRedisTemplate ){
      this.reactiveRedisTemplate = reactiveRedisTemplate;
  }

  public Mono<List<RoutesBean>> selectAllRoutes(){

      return null;
  }
}
