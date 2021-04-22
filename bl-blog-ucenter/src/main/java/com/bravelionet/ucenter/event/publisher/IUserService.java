package com.bravelionet.ucenter.event.publisher;


import com.bravelionet.domain.ucenter.User;

/**
 * @Author : Lionet
 * @Date : 2021/4/21  14:48
 * @Description :
 */
public interface IUserService {

    /**
     * <p> 添加用户信息 </p>
     *
     * @param user 用户信息
     * @return
     * @author : Lionet
     * @date : 2021/4/21  14:48
     */
    public User addUser(User user);
    /**
     * <p> 删除用户信息 </p>
     *
     * @param
     * @return
     * @author : Lionet
     * @date : 2021/4/21  14:58
     */
    public User delete(User user);
}
