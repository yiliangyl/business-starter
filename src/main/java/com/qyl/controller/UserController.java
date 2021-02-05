package com.qyl.controller;

import com.qyl.pojo.User;
import com.qyl.service.UserService;
import com.qyl.utils.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: qyl
 * @Date: 2020/12/7 9:53
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<Void> register(@Validated @RequestBody User user) {
        return userService.register(user);
    }

    /**
     * 通过用户名查询用户
     * @param username
     * @return
     */
    @GetMapping("/query/{username}")
    public  ResponseEntity<User> queryUserByName(@PathVariable("username") String username) {
        return userService.queryUserByName(username);
    }
}
