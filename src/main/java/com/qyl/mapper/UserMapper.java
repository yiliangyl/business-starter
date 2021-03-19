package com.qyl.mapper;

import com.qyl.pojo.User;

/**
 * @Author: qyl
 * @Date: 2020/12/7 9:49
 */
public interface UserMapper {

    // 通过用户名获取用户
    User selectUserByName(String username);

    // 通过手机号获取用户
    User selectUserByPhone(String phone);

    // 通过 ID 获取用户
    User selectUserById(Integer userId);

    // 添加用户
    int insertUser(User user);
}
