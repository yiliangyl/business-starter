package com.qyl.service.impl;

import com.qyl.enums.ResponseEnum;
import com.qyl.mapper.UserMapper;
import com.qyl.pojo.User;
import com.qyl.service.UserService;
import com.qyl.utils.ResponseEntity;
import com.qyl.utils.component.PwdEncoderUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

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
        // 判断用户是否存在
        if (userMapper.selectByName(user.getUsername()) != null || userMapper.selectByPhone(user.getPhone()) != null) {
            return ResponseEntity.error(ResponseEnum.USER_EXIST.getCode(), ResponseEnum.USER_EXIST.getMsg());
        }
        try {
            user.setPassword(PwdEncoderUtil.encodeByMD5(user.getPassword()));
            user.setCreated(new Date());
            userMapper.insertSelective(user);
            return ResponseEntity.ok();
        } catch (Exception e) {
            return ResponseEntity.fail();
        }
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
