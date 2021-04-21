package com.bravelionet.dispatch.service.event.instance;

import com.bravelionet.domain.ucenter.User;
import org.springframework.context.ApplicationEvent;

/**
 * @Author : Lionet
 * @Date : 2021/4/21  10:20
 * @Description : 定义一个用户事件
 */
public class UserPublisherEvent extends ApplicationEvent {

    /**
     * 定义数据传输模型
     */
    private User user;

    public UserPublisherEvent(User user) {
        super(user);
        this.user = user;
    }


    @Override
    public Object getSource() {
        return super.getSource();
    }
}
