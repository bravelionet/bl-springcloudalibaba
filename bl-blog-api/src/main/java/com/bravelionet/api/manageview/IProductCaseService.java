package com.bravelionet.api.manageview;

/**
 * @Author Lionet
 * @Date 2021/4/8 21:44
 * @Description 用户账户操作
 */

public interface IProductCaseService {

    /**
     * <p> 根据商品ID修改数量 </p>
     *
     * @param id    商品Id
     * @param mount 商品数量
     * @return
     * @author Lionet
     * @date 2021/4/8 21:52
     */
    public int updateById(Long id, Integer mount);
}