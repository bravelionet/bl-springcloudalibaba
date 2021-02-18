package com.bravelionet.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.bravelionet.api.manageview.InitRoutesService;
import com.bravelionet.common.response.TypicResponseUtils;
import com.bravelionet.common.response.TypicalRep;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : Lionet
 * @Date : 2021/2/8  17:20
 * @Description : 初始化 routes
 */
@RestController
@RequestMapping("/init")
public class InitRoutesController {

    InitRoutesService iInitRoutesService;

    public InitRoutesController(InitRoutesService iInitRoutesService) {
        this.iInitRoutesService = iInitRoutesService;
    }

    @GetMapping("/routes-all")
    @SentinelResource(value = "selectAll")
    public TypicalRep<Object> selectAll() {

        return TypicResponseUtils.success(iInitRoutesService.selectAll());

    }
}
