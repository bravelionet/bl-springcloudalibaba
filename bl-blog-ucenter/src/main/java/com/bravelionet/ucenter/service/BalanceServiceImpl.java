package com.bravelionet.ucenter.service;

import com.bravelionet.api.ucenter.IBalanceService;
import com.bravelionet.dao.ucenter.BalanceMapper;
import org.springframework.stereotype.Service;

/**
 * @Author Lionet
 * @Date 2021/4/8 21:44
 * @Description 用户账户操作
 */
@Service
public class BalanceServiceImpl implements IBalanceService {

    BalanceMapper balanceMapper;

    public BalanceServiceImpl(BalanceMapper balanceMapper) {
        this.balanceMapper = balanceMapper;
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
    public int updateMoneyByUserId(Long money, Long userId){
        int i = balanceMapper.updateMoneyByUserId(money, userId);
        return i;
    }
}
