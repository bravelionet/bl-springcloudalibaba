package com.bravelionet.api.ucenter;

/**
 * @Author Lionet
 * @Date 2021/4/8 21:44
 * @Description 用户账户操作
 */

public interface IBalanceService {

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
    public int updateMoneyByUserId(Long money, Long userId);
}
