package com.bravelionet.domain.manageview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author Lionet
 * @Date 2021/4/8 21:40
 * @Description 商品明细
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductCase {

    private String id;

    private String productName;

    private Integer amount;

    private Long price;

    private Long userId;

}
