package com.bravelionet.controller;

import com.bravelionet.api.manageview.IProductCaseService;
import com.bravelionet.common.response.TypicResponseUtils;
import com.bravelionet.common.response.TypicalRep;
import com.bravelionet.dao.manageview.ProductCaseMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Lionet
 * @Date 2021/4/8 22:03
 * @Description 用户账户操作
 */
@RestController
@RequestMapping("/product-case")
public class ProductCaseController  {

    private final IProductCaseService iProductCaseService;

    public ProductCaseController(IProductCaseService iProductCaseService) {
        this.iProductCaseService = iProductCaseService;
    }


    /**
     * <p> 根据商品ID修改数量 </p>
     *
     * @param id    商品Id
     * @param mount 商品数量
     * @return
     * @author Lionet
     * @date 2021/4/8 21:52
     */
    @GetMapping("/v1/update-by-id/{id}/{mount}")
    public TypicalRep<Object> updateById(@PathVariable("id") Long id,@PathVariable("mount") Integer mount) {
        int i = iProductCaseService.updateById(id, mount);
        return TypicResponseUtils.success(i);
    }
}
