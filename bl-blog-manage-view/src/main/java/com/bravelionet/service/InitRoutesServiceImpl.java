package com.bravelionet.service;

import com.bravelionet.api.manageview.InitRoutesService;
import com.bravelionet.dao.manageview.InitRoutesMapper;
import com.bravelionet.domain.manageview.RoutesBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : Lionet
 * @Date : 2021/2/8  17:21
 * @Description :
 */
@Service
public class InitRoutesServiceImpl implements InitRoutesService {

    private static final Logger logger = LoggerFactory.getLogger(InitRoutesServiceImpl.class);

    InitRoutesMapper initRoutesMapper;

    public InitRoutesServiceImpl(InitRoutesMapper initRoutesMapper) {

        this.initRoutesMapper = initRoutesMapper;
    }

    @Override
    public List<RoutesBean> selectAll() {
        List<RoutesBean> routesBeans = initRoutesMapper.selectAll();
        logger.info(" select All  reoutes list  [ {} ]",routesBeans);
        return routesBeans;
    }
}
