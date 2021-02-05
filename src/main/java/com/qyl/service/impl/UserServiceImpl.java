package com.qyl.service.impl;

import com.qyl.mapper.UserMapper;
import com.qyl.pojo.User;
import com.qyl.service.UserService;
import com.qyl.utils.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: qyl
 * @Date: 2020/12/7 9:51
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public ResponseEntity<Void> register(User user) {
        return null;
    }

    @Override
    public ResponseEntity<User> queryUserByName(String username) {
        User record = new User();
        record.setUsername(username);
        User user = userMapper.selectOne(record);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.fail();
    }
}
