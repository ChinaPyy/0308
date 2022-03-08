package com.example.service;

import org.springframework.web.multipart.MultipartFile;

public interface VodService {
    //上传视频到阿里云
    String uploadVideoAly(MultipartFile file);

    //删除视频
    void removeVideo(String videoId);

}
