package com.qyl.controller;

import com.qyl.pojo.PO.TokenPO;
import com.qyl.pojo.User;
import com.qyl.service.UserService;
import com.qyl.utils.ResponseResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.constraints.Pattern;

/**
 * 用户相关接口
 * @Author: qyl
 * @Date: 2020/12/7 9:53
 * @Description: 用户相关接口
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户注册
     * @param user
     * @param verifyCode 验证码
     * @param file 头像文件
     * @return 根据用户手机号生成的 token
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
    public ResponseResult<User> queryUserByName(String username) {
        return userService.queryUserByName(username);
    }

    /**
     * 发送验证码
     * @param phone
     * @return
     */
    @PostMapping("/send")
    public ResponseResult<String> sendVerificationCode(
            @Pattern(regexp = "^1[35678]\\d{9}$", message = "手机格式不正确") String phone) {
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
