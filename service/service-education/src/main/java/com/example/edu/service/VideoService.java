package com.example.edu.service;

import com.example.edu.entity.Video;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.edu.entity.vo.VideoInfoForm;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-01-14
 */
public interface VideoService extends IService<Video> {

    boolean getCountByChapterId(String id);

    void saveVideoInfo(VideoInfoForm videoInfoForm);

    void updateVideoInfoById(VideoInfoForm videoInfoForm);

    VideoInfoForm getVideoInfoFormById(String id);

    boolean removeVideoById(String id);

    boolean removeByCourseId(String id);
}
