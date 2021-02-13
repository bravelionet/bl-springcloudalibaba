package com.bravelionet.api.ucenter;

import com.bravelionet.domain.ucenter.User;

/**
 * @Author : Lionet
 * @Date : 2021/2/7  9:20
 * @Description : 用户基础设施类
 */
public interface IUserQueryService {


    /**
     * 根据用户ID,查询用户信息
     *
     * @param id : user id
     * @return  用户实体
     * @author : Lionet
     * @date : 2021/2/7  10:56
     */
    public User selectUserById(Long id);
}
