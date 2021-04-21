package com.bravelionet.dispatch.service.event.publisher.service;

import com.bravelionet.dispatch.service.event.instance.UserPublisherEvent;
import com.bravelionet.domain.ucenter.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author : Lionet
 * @Date : 2021/4/21  10:53
 * @Description : 用户发布事件执行器
 */
@Service
public class UserEventPulisher  {

    private final EventPublisherService eventPublisherService;

    public UserEventPulisher(EventPublisherService eventPublisherService) {
        this.eventPublisherService = eventPublisherService;
    }

    /**
     * <p> 发布用户事件 </p>
     *
     * @param
     * @return
     * @author : Lionet
     * @date : 2021/4/21  10:52
     */
    public void pulisherUserEvent(User user) {

        eventPublisherService.publishEvent(createUserPublisherEvent(user));
    }

    public UserPublisherEvent createUserPublisherEvent(User user){
        return  new UserPublisherEvent(user);
    }
}
