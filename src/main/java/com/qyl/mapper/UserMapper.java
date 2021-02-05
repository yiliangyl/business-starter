package com.qyl.mapper;

import com.qyl.pojo.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author: qyl
 * @Date: 2020/12/7 9:49
 */
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {

    @Select("select * from user where username = #{username} limit 1")
    User selectByName(String username);

    @Select("select * from user where phone = #{phone} limit 1")
    User selectByPhone(String phone);
}
