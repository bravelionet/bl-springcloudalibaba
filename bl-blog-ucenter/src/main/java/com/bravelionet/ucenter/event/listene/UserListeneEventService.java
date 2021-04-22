package com.bravelionet.ucenter.event.listene;

import com.alibaba.fastjson.JSON;
import com.bravelionet.ucenter.event.instance.UserPublisherEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

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
     * <p>  {@link EventListener}  指定 phase 事务同步器标记,TransactionPhase.AFTER_COMMIT代表当发布者事务提交后才被监听</p>
     *
     * @param userPublisherEvent 发布事件数据
     * @return
     * @author : Lionet
     * @date : 2021/4/21  11:48
     */
    @Async
    @TransactionalEventListener(value = UserPublisherEvent.class, condition = "#userPublisherEvent.enumUserOperate.operate.equals('add')",phase = TransactionPhase.AFTER_COMMIT)
    public void listeneUser(UserPublisherEvent userPublisherEvent) {
        logger.info(" one 监听用户事件 [ info: {} ]", JSON.toJSONString(userPublisherEvent));
      /*  try {

            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //throw new RuntimeException();

    }

}
