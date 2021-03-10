package com.qyl.utils.component;

import org.apache.tomcat.util.security.MD5Encoder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 数据加密工具类
 * @Author: qyl
 * @Date: 2021/2/5 11:22
 */
public class EncryptUtil {

    /**
     * 数据加密
     * @param origin 原始数据
     * @return 加密数据
     */
    public static String encryptByMD5(String origin) {
        String encrypt = "";
        try {
            // 确定计算方法
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            // 通过MD5加密
            encrypt = MD5Encoder.encode(md5.digest(origin.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encrypt;
    }
}
