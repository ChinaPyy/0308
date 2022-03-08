package com.example.service;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * 创建人:楚克旺
 * 创建时间:2022/1/13 16:10
 **/
@Component
public interface OssService {


    /**
     * 文件上传至阿里云
     *
     * @param file
     * @return
     */
    String upload(MultipartFile file);
}
