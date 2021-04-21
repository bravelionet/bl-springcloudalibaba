package com.bravelionet.dispatch.service.event.listene;

import com.alibaba.fastjson.JSON;
import com.bravelionet.dispatch.service.event.instance.UserPublisherEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author : Lionet
 * @Date : 2021/4/21  11:03
 * @Description : 用户监听器
 */
@Service
public class UserListeneEventService2 {

private final static Logger logger = LoggerFactory.getLogger(UserListeneEventService2.class);

    /**
     * <p>  事件监听方法  </p>
     * <p>  不进行开启 {@link Async} 时事件发布者会等待监听器执行完成  </p>
     *
     * @param userPublisherEvent 发布事件数据
     * @return
     * @author : Lionet
     * @date : 2021/4/21  11:48
     */
    @Async
    @EventListener(UserPublisherEvent.class)
    public void listeneUser(UserPublisherEvent userPublisherEvent){
        //throw new RuntimeException();
        logger.info(" two 监听用户事件 [ info: {} ]", JSON.toJSONString(userPublisherEvent.getSource()));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
