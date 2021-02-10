package com.qyl.mapper;

import com.qyl.pojo.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author: qyl
 * @Date: 2020/12/7 9:49
 */
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {

    /* 通过用户名获取用户 */
    User selectByName(String username);

    /* 通过手机号获取用户 */
    User selectByPhone(String phone);
}
