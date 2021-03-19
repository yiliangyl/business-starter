package com.qyl.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @Author: qyl
 * @Date: 2020/12/7 9:49
 */
@Data
public class User {

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 用户头像储存路径
     */
    private String avatar;

    /**
     * 创建时间
     */
    private Date createTime;
}
