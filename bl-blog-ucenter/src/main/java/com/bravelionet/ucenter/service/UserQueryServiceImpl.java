package com.bravelionet.ucenter.service;

import com.bravelionet.api.ucenter.IUserQueryService;
import com.bravelionet.dao.ucenter.UserMapper;
import com.bravelionet.domain.ucenter.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @Author : Lionet
 * @Date : 2021/2/7  10:58
 * @Description : 用户操作类
 */
@Service
public class UserQueryServiceImpl implements IUserQueryService {

    private final static Logger logger = LoggerFactory.getLogger(UserQueryServiceImpl.class);

    private UserMapper userMapper;

    public UserQueryServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public User selectUserById(Long id) {

        Assert.notNull(id, " id must not null ");

        User user = userMapper.selectUserById(id);

        return user;
    }
}
