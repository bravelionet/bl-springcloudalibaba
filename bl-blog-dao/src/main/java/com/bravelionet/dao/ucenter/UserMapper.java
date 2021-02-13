package com.bravelionet.dao.ucenter;

import com.bravelionet.domain.ucenter.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author : Lionet
 * @Date : 2021/2/7  11:01
 * @Description : 用户操作
 */
@Mapper
public interface UserMapper {


    /**
     * 根据 Id 查询用户信息
     *
     * @param id : 用户Id
     * @return
     * @author : Lionet
     * @date : 2021/2/7  10:42
     */

    public User selectUserById(@Param("id") Long id );
}

