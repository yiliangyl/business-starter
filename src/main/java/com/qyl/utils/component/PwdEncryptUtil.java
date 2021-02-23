package com.qyl.utils.component;

import org.apache.tomcat.util.security.MD5Encoder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * 密码加密工具类
 * @Author: qyl
 * @Date: 2021/2/5 11:22
 */
public class PwdEncryptUtil {

    /**
     * 密码加密
     * @param password
     * @return
     * @throws Exception
     */
    public static String encryptByMD5(String password) throws Exception {
        // 确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        // 通过MD5加密
        String encryptPwd = MD5Encoder.encode(md5.digest(password.getBytes(StandardCharsets.UTF_8)));
        return encryptPwd;
    }
}
