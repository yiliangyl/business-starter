package com.qyl.controller;

import com.qyl.annotation.TokenRequired;
import com.qyl.pojo.PO.TokenPO;
import com.qyl.pojo.User;
import com.qyl.service.UserService;
import com.qyl.utils.ResponseResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * 用户相关接口
 * @Author: qyl
 * @Date: 2020/12/7 9:53
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户注册
     * @param user
     * @param verifyCode 验证码
     * @param file 头像文件
     * @return 根据用户ID生成的 token
     */
    @PostMapping("/register")
    public ResponseResult<String> register(User user, String verifyCode, MultipartFile file) {
        return userService.register(user, verifyCode, file);
    }

    /**
     * 通过用户名查询用户
     * @param username
     * @return
     */
    @GetMapping("/query")
    @TokenRequired
    public ResponseResult<User> queryUserByName(String username) {
        return userService.queryUserByName(username);
    }

    /**
     * 发送验证码
     * @param phone
     * @return
     */
    @PostMapping("/send")
    public ResponseResult<String> sendVerificationCode(String phone) {
        return userService.sendVerificationCode(phone);
    }

    /**
     * 用户登录
     * @param phone
     * @param password
     * @return
     */
    @GetMapping("/login")
    public ResponseResult<TokenPO> login(String phone, String password) {
        return userService.login(phone, password);
    }
}
