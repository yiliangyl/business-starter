package com.qyl.service.impl;

import com.aliyun.oss.OSS;
import com.qyl.config.AliyunConfig;
import com.qyl.service.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author: qyl
 * @Date: 2021/2/21 13:58
 * @Description:
 */
@Service
public class UploadServiceImpl implements UploadService {

    @Resource
    private OSS oss;

    @Resource
    private AliyunConfig aliyunConfig;

    /**
     * 图片扩展名
     */
    private static final String IMG_EXT_NAME = "png";

    @Override
    public String uploadAvatar(MultipartFile avatar) {
        String filename = UUID.randomUUID().toString() + "." + IMG_EXT_NAME;
        String filePath = "image/" + filename;
        try {
            // 存储到oss
            oss.putObject(aliyunConfig.getBucketName(), filePath, new ByteArrayInputStream(avatar.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        // 返回url
        String url = aliyunConfig.getUrlPrefix() + filename;
        return url;
    }
}
