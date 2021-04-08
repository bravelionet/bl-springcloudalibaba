package com.bravelionet.dao.manageview;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Lionet
 * @Date 2021/4/8 21:45
 * @Description 商品管理
 */
@Mapper
public interface ProductCaseMapper {


    /**
     * <p> 根据商品ID修改数量 </p>
     * @param id 商品Id
     * @param mount 商品数量
     * @return
     * @author Lionet
     * @date 2021/4/8 21:52
     */
    public int updateById(@Param("id") Long id,@Param("amount") Integer mount);
}
