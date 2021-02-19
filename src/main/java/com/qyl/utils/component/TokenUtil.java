package com.qyl.utils.component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Calendar;

/**
 * @Author: qyl
 * @Date: 2021/2/9 11:38
 * @Description: token生成工具类
 */
public class TokenUtil {

    private static final String signature = "Q!w2XS%^63p*";

    private static final String PAYLOAD_NAME = "user_id";

    /**
     * 通过用户ID生成token
     * @param phone
     * @return
     */
    public static String genToken(String phone) {
        String token;
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7);  // 默认7天过期

        token = JWT.create()
                .withClaim(PAYLOAD_NAME, phone)
                .withExpiresAt(instance.getTime())  // 指定token过期时间
                .sign(Algorithm.HMAC256(signature));

        return token;
    }

    /**
     * 验证token
     * 若验证出错将会抛出异常
     * @param token
     * @return 用户信息(userId)
     */
    public static String verifyToken(String token) {
        return JWT.require(Algorithm.HMAC256(signature))
                .build()
                .verify(token)
                .getClaim(PAYLOAD_NAME)
                .asString();
    }
}
