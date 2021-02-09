package com.qyl.utils.component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

/**
 * @Author: qyl
 * @Date: 2021/2/9 11:38
 * @Description: token生成工具类
 */
public class TokenUtil {

    /**
     * 通过用户ID生成token
     * @param userId
     * @return
     */
    public static String generateToken(Integer userId) {
        String token;
        // withAudience()存入需要保存在token的信息，这里把用户ID存入token中
        token = JWT.create().withAudience(String.valueOf(userId))
                .sign(Algorithm.HMAC256(String.valueOf(userId)));
        return token;
    }
}
