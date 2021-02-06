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

    /**
     * 发送验证码
     * @param phone
     * @return
     */
    ResponseEntity<String> sendVerificationCode(String phone);

    /**
     * 校验验证码
     * @param phone
     * @param verificationCode
     * @return
     */
    ResponseEntity<Void> checkVerificationCode(String phone, String verificationCode);

    /**
     * 用户登录
     * @param phone
     * @param password
     * @return
     */
    ResponseEntity<User> login(String phone, String password);
}
