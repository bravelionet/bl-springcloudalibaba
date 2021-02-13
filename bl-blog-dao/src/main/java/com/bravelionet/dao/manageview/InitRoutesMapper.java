package com.bravelionet.dao.manageview;

import com.bravelionet.domain.manageview.RoutesBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InitRoutesMapper {

    /**
     * 查询 所有可用路由
     *
     * @param
     * @return
     * @author : Lionet
     * @date : 2021/2/8  17:23
     */
    List<RoutesBean> selectAll();
}
