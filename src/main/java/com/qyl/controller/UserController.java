package com.qyl.controller;

import com.qyl.pojo.PO.TokenPO;
import com.qyl.pojo.User;
import com.qyl.service.UserService;
import com.qyl.utils.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @Author: qyl
 * @Date: 2020/12/7 9:53
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户注册
     * @param phone
     * @param verificationCode
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<Void> register(
            @Pattern(regexp = "^1[35678]\\d{9}$", message = "手机格式不正确") String phone,
            String verificationCode,
            @Size(min = 2, max = 20, message = "用户名应在2~20位") String username,
            @Size(min = 6, max = 20, message = "密码应在6~20位") String password) {
        User user = new User(username, password, phone);
        return userService.register(user, verificationCode);
    }

    /**
     * 通过用户名查询用户
     * @param username
     * @return
     */
    @GetMapping("/query/{username}")
    public ResponseEntity<User> queryUserByName(@PathVariable("username") String username) {
        return userService.queryUserByName(username);
    }

    /**
     * 发送验证码
     * @param phone
     * @return
     */
    @PostMapping("/send")
    public ResponseEntity<String> sendVerificationCode(
            @Pattern(regexp = "^1[35678]\\d{9}$", message = "手机格式不正确") String phone) {
        return userService.sendVerificationCode(phone);
    }

    /**
     * 用户登录
     * @param phone
     * @param password
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<TokenPO> login(String phone, String password) {
        return userService.login(phone, password);
    }
}
