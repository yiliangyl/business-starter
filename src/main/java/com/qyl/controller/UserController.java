package com.qyl.controller;

import com.qyl.pojo.User;
import com.qyl.service.UserService;
import com.qyl.utils.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

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
     * @param user
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid @RequestBody User user) {
        return userService.register(user);
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
     * 校验验证码
     * @param phone
     * @param verificationCode
     * @return
     */
    @PostMapping("/check")
    public ResponseEntity<Void> checkVerificationCode(
            String phone,
            @NotBlank(message = "验证码不能为空") String verificationCode) {
        return userService.checkVerificationCode(phone, verificationCode);
    }
}
