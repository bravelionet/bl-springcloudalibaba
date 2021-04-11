package com.bravelionet.service;

import com.bravelionet.api.manageview.IProductCaseService;
import com.bravelionet.dao.manageview.ProductCaseMapper;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

/**
 * @Author Lionet
 * @Date 2021/4/8 22:03
 * @Description 用户账户操作
 */
@Service
public class ProductCaseServiceImpl  implements IProductCaseService {

    private final ProductCaseMapper productCaseMapper;

    public ProductCaseServiceImpl(ProductCaseMapper productCaseMapper) {
        this.productCaseMapper = productCaseMapper;
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
    @Override
    @GlobalTransactional
    public int updateById(Long id, Integer mount) {
        productCaseMapper.updateById(id,mount);
        return 0;
    }
}
