package com.bravelionet.domain.manageview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author : Lionet
 * @Date : 2021/2/8  15:42
 * @Description : 实现动态路由
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoutesBean {

    private Long id;

    private String routesId;

    private String routesUri;

    private String toutesPredicates;

    private Date createTime;

    private String routesStatus;


}
