package com.example.edu.service;

import com.example.edu.entity.Chapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.edu.entity.vo.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-01-14
 */
public interface ChapterService extends IService<Chapter> {

    List<ChapterVo> nestedList(String courseId);

    boolean removeChapterById(String id);

    boolean removeByCourseId(String id);
}
