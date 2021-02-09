package com.qyl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

/**
 * @Author: qyl
 * @Date: 2021/2/9 19:31
 * @Description:
 */
public class CommonTest {

    private static final String salt = "!q@w#e$r";

    @Test
    public void generateToken() {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 5 * 60);

        String token = JWT.create()
                // .withHeader() header 建议使用默认的即可
                .withClaim("userId", "25")  // payload
                .withClaim("username", "admin")
                .withExpiresAt(instance.getTime())  // 指定token过期时间
                .sign(Algorithm.HMAC256(salt));  // 签名，其中算法中的字符串为自定义的盐值（不能泄露）

        System.out.println(token);
    }

    @Test
    public void checkToken() {
        // 创建对象
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(salt)).build();
        DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MTI4NzI3MjAsInVzZXJJZCI6IjI1IiwidXNlcm5hbWUiOiJhZG1pbiJ9.qzSQU0fClxSFJ0racsfT5N67kkaQqNEIDG_99WLjkZY");

        System.out.println(verify.getClaim("userId").asString());
        System.out.println(verify.getClaim("username").asString());
    }
}
