package com.bravelionet.ucenter.controller;

import com.bravelionet.api.ucenter.IBalanceService;
import com.bravelionet.common.response.TypicResponseUtils;
import com.bravelionet.common.response.TypicalRep;
import com.bravelionet.dao.ucenter.BalanceMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Lionet
 * @Date 2021/4/8 21:44
 * @Description 用户账户操作
 */
@RestController
@RequestMapping("/balance")
public class BalanceController {

    IBalanceService iBalanceService;

    public BalanceController(IBalanceService iBalanceService) {
        this.iBalanceService = iBalanceService;
    }

    /**
     *
     * <p> 根据用户Id 扣减消费金额 </p>
     *
     * @param money  消费金额
     * @param userId 用户ID
     * @return
     * @author Lionet
     * @date 2021/4/8 21:54
     */
    @GetMapping("/v1/update-money-by-user-d/{money}/{userId}")
    public TypicalRep<Object> updateMoneyByUserId(@PathVariable("money") Long money, @PathVariable("userId") Long userId){
        int i = iBalanceService.updateMoneyByUserId(money, userId);
        return TypicResponseUtils.success(i);
    }
}
