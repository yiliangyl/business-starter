package com.qyl.controller;

import com.qyl.enums.ResponseEnum;
import com.qyl.utils.ResultMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: qyl
 * @Date: 2020/12/7 9:53
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/ping")
    public ResultMessage ping() {
        return ResultMessage.success(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg(), "pong");
    }
}
