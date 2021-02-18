package com.bravelionet.ucenter.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.bravelionet.api.ucenter.IUserQueryService;
import com.bravelionet.domain.ucenter.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : Lionet
 * @Date : 2021/2/7  15:20
 * @Description : Ucenter 暴露类查询错误接口
 */
@RestController
@RequestMapping("/ucenter")
public class UserQueryController {

    @Autowired
    IUserQueryService iUserQueryService;

    @GetMapping("/select-user-by-id/{id}")
    @SentinelResource(value = "selectUserById")
    public User selectUserById(@PathVariable("id") Long id) {
        User user = iUserQueryService.selectUserById(id);
        return user;
    }
}
