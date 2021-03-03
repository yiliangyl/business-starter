package com.qyl.utils.component;

import org.apache.tomcat.util.security.MD5Encoder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
     */
    public static String encryptByMD5(String password) {
        String encryptPwd = "";
        try {
            // 确定计算方法
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            // 通过MD5加密
            encryptPwd = MD5Encoder.encode(md5.digest(password.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encryptPwd;
    }
}
