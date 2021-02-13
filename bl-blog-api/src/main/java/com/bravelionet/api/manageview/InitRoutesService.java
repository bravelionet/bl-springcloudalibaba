package com.bravelionet.api.manageview;

import com.bravelionet.domain.manageview.RoutesBean;

import java.util.List;

/**
 * @Author : Lionet
 * @Date : 2021/2/8  17:18
 * @Description : init routes
 */
public interface InitRoutesService {

    /**
     * 查询所有 可用 routes
     *
     * @param
     * @return
     * @author : Lionet
     * @date : 2021/2/8  17:19
     */
    List<RoutesBean> selectAll();

}
