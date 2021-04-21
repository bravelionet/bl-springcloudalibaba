package com.bravelionet.dispatch.service.event.publisher.service;

import com.bravelionet.dispatch.service.event.publisher.IEventPublisher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Service;

/**
 * @Author : Lionet
 * @Date : 2021/4/21  10:44
 * @Description : 事件发布
 */
@Service
public class EventPublisherService implements IEventPublisher {

    private ApplicationContext applicationContext;

    public EventPublisherService(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void publishEvent(ApplicationEvent applicationEvent) {
        // 事务同步注册器
       // TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
      //      @Override
       //     public void afterCommit() {
                applicationContext.publishEvent(applicationEvent);
        //    }
       // });
    }

    @Override
    public void publishEvent(Object event) {
    //    TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
        //    @Override
        //    public void afterCommit() {
                applicationContext.publishEvent(event);
      //      }
      //  });
    }
}