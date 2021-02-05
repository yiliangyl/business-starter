package com.qyl.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @Author: qyl
 * @Date: 2020/12/7 9:49
 */
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Length(min = 2, max = 20, message = "用户名应在2~20位")
    private String username;

    @JsonIgnore
    @Length(min = 6, max = 20, message = "密码应在6~20位")
    private String password;

    @Pattern(regexp = "^1[35678]\\d{9}$", message = "手机格式不正确")
    private String phone;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm", timezone = "Asia/Shanghai")
    private Date created;   // 创建时间
}
