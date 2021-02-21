package com.qyl.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: qyl
 * @Date: 2021/2/21 13:58
 * @Description: 上传文件服务类
 */
public interface UploadService {

    /**
     * 上传头像
     * @param avatar
     * @return
     */
    String uploadAvatar(MultipartFile avatar);
}
