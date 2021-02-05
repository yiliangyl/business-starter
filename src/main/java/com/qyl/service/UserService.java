package com.qyl.service;

import com.qyl.pojo.User;
import com.qyl.utils.ResponseEntity;

/**
 * @Author: qyl
 * @Date: 2020/12/7 9:50
 */
public interface UserService {

    /**
     * 用户注册
     * @param user
     * @return
     */
    ResponseEntity<Void> register(User user);

    /**
     * 通过用户名查询用户
     * @param username
     * @return
     */
    ResponseEntity<User> queryUserByName(String username);
}
