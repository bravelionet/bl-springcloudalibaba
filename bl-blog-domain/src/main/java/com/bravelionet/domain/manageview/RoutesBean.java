package com.bravelionet.domain.manageview;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author : Lionet
 * @Date : 2021/2/8  15:42
 * @Description : 实现动态路由
 */
@Data
@NoArgsConstructor
@ToString
public class RoutesBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String routesId;

    private String routesUri;

    private String toutesPredicates;

    @JsonFormat(pattern="yyyy-MM-dd mm:hh:ss",timezone="GMT+8")
    private String createTime;

    private String routesStatus;


}
