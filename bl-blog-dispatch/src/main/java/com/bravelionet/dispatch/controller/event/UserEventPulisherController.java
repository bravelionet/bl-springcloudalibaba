package com.bravelionet.dispatch.controller.event;

import com.bravelionet.dispatch.service.event.publisher.IUserService;
import com.bravelionet.domain.ucenter.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class UserEventPulisherController {

    private final static Logger logger = LoggerFactory.getLogger(UserEventPulisherController.class);

    private final IUserService iUserService;

    public UserEventPulisherController(IUserService iUserService) {
        this.iUserService = iUserService;
    }
    @GetMapping("/pulisher/user")
    public void testUserEventPulisherController(){

        User user = new User();
        user.setId(1L);
        user.setUserName("lionet");
        user.setAddress("华东地区");
        user.setAge(99);
        user.setSex(1);
        iUserService.addUser(user);
        iUserService.delete(user);
        logger.info("发布用户事件完成 ");

    }
}
