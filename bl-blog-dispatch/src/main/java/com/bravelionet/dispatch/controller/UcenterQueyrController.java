package com.bravelionet.dispatch.controller;

import com.bravelionet.common.response.TypicResponseUtils;
import com.bravelionet.common.response.TypicalRep;
import com.bravelionet.domain.ucenter.User;
import com.bravelionet.feign.client.manageview.BlBlogManageViewClient;
import com.bravelionet.feign.client.ucenter.UcenterClient;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author : Lionet
 * @Date : 2021/2/7  15:51
 * @Description : 用户查询基础控制器
 */
@RestController
@RequestMapping("/ucenter")
@RefreshScope
public class UcenterQueyrController {

    UcenterClient ucenterClient;

    BlBlogManageViewClient blBlogManageViewClient;

    public UcenterQueyrController(UcenterClient ucenterClient, BlBlogManageViewClient blBlogManageViewClient) {
        this.ucenterClient = ucenterClient;
        this.blBlogManageViewClient = blBlogManageViewClient;
    }

    /**
     * 根据 Id 查询用户信息
     *
     * @param
     * @return
     * @author : Lionet
     * @date : 2021/2/7  15:53
     */
    @GetMapping("/find-user-y-id/{id}")
    public TypicalRep<Object> findUserById(@PathVariable("id") Long id) {


        System.out.println("id = " + id);
        User user = ucenterClient.selectUserById(id);
        System.out.println("user = " + user);
        HashMap<Object, Object> response = new HashMap<>();
        response.put("id", id);
        response.put("user", user);

        return TypicResponseUtils.success(response);
    }


    @GetMapping("/test")
    @GlobalTransactional
    public TypicalRep<Object> test() {
        TypicalRep<Object> objectTypicalRep = ucenterClient.updateMoneyByUserId(10L, 1000L);
        TypicalRep<Object> objectTypicalRep1 = blBlogManageViewClient.updateById(1L, 2);

        return TypicResponseUtils.success();
    }
}
