package com.bravelionet.dispatch.service.event.listene;

import com.alibaba.fastjson.JSON;
import com.bravelionet.dispatch.service.event.instance.UserPublisherEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Author : Lionet
 * @Date : 2021/4/21  11:03
 * @Description : 用户监听器
 */
@Component
public class UserListeneEventService {

    private final static Logger logger = LoggerFactory.getLogger(UserListeneEventService.class);

    /**
     * <p>  事件监听方法  </p>
     * <p>  不进行开启 {@link Async} 时事件发布者会等待监听器执行完成  </p>
     * <p>  {@link EventListener}  指定 condition 可进行颗粒度缩小 </p>
     *
     * @param userPublisherEvent 发布事件数据
     * @return
     * @author : Lionet
     * @date : 2021/4/21  11:48
     */
    @Async
    @EventListener(value = UserPublisherEvent.class, condition = "#userPublisherEvent.enumUserOperate.operate.equals('add')")
    public void listeneUser(UserPublisherEvent userPublisherEvent) {
        logger.info(" one 监听用户事件 [ info: {} ]", JSON.toJSONString(userPublisherEvent));
        try {

            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //throw new RuntimeException();

    }

}
