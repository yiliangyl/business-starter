package com.qyl.service;

import com.qyl.pojo.PO.TokenPO;
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
     * @param verificationCode
     * @return
     */
    ResponseEntity<String> register(User user, String verificationCode);

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
     * 用户登录
     * @param phone
     * @param password
     * @return
     */
    ResponseEntity<TokenPO> login(String phone, String password);
}
