package com.bravelionet.ucenter.event.instance;

import com.bravelionet.common.enums.EnumUserOperate;
import com.bravelionet.domain.ucenter.User;
import lombok.*;
import org.springframework.context.ApplicationEvent;

/**
 * @Author : Lionet
 * @Date : 2021/4/21  10:20
 * @Description : 定义一个用户事件
 */
@Getter
@Setter
@ToString
public class UserPublisherEvent extends ApplicationEvent {

    /**
     * 操作是否成功
     */
    private Boolean success;

    /***
     * 操作类型
     */
    private EnumUserOperate enumUserOperate;
    /**
     * 定义数据传输模型
     */
    private User user;


    public UserPublisherEvent(Object oject) {
        super(oject);
    }



}
