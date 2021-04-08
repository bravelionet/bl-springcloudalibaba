package com.bravelionet.dao.ucenter;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author Lionet
 * @Date 2021/4/8 21:44
 * @Description 用户账户操作
 */
@Mapper
public interface BalanceMapper {

    /**
     * <p> 根据用户Id 扣减消费金额 </p>
     * @param money 消费金额
     * @param userId 用户ID
     * @return
     * @author Lionet
     * @date 2021/4/8 21:54
     */
    public int updateMoneyByUserId(@Param("money") Long money,@Param("userId") Long userId);

}
