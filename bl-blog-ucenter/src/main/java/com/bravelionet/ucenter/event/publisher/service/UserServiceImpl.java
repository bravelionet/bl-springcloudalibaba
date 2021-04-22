package com.bravelionet.ucenter.event.publisher.service;

import com.bravelionet.common.enums.EnumUserOperate;
import com.bravelionet.ucenter.event.instance.UserPublisherEvent;
import com.bravelionet.ucenter.event.publisher.IUserService;
import com.bravelionet.domain.ucenter.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author : Lionet
 * @Date : 2021/4/21  14:53
 * @Description : 用户操作类
 */
@Service
public class UserServiceImpl implements IUserService {
    
    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    
    private EventPublisherService eventPublisherService;

    public UserServiceImpl(EventPublisherService eventPublisherService) {
        this.eventPublisherService = eventPublisherService;
    }

    /**
     * <p> 事件发布添加用户信息  </p>
     *
     * @param
     * @return
     * @author : Lionet
     * @date : 2021/4/21  14:54
     */
    @Transactional
    @Override
    public User addUser(User user) {
        UserPublisherEvent userPublisherEvent = new UserPublisherEvent(this);
        userPublisherEvent.setSuccess(true);
        userPublisherEvent.setEnumUserOperate(EnumUserOperate.ADD);
        userPublisherEvent.setUser(user);
        logger.info("发布用户事件  ");
        eventPublisherService.publishEvent(userPublisherEvent);
        logger.info("发布用户事件完成  ");
       // throw  new RuntimeException();
        return user;
    }
    @Transactional
    @Override
    public User delete(User user) {
        UserPublisherEvent userPublisherEvent = new UserPublisherEvent(this);
        userPublisherEvent.setSuccess(true);
        userPublisherEvent.setEnumUserOperate(EnumUserOperate.DELETE);
        userPublisherEvent.setUser(user);
        logger.info("发布用户事件  ");
        eventPublisherService.publishEvent(userPublisherEvent);
        return user;
    }
}
