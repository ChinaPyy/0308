package com.example.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.edu.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.edu.entity.vo.CourseInfoForm;
import com.example.edu.entity.vo.CoursePublishVo;
import com.example.edu.query.CourseQuery;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-01-14
 */
public interface CourseService extends IService<Course> {

    /**
     * 保存课程和课程详情信息
     *
     * @param courseInfoForm
     * @return 新生成的课程id
     */
    String saveCourseInfo(CourseInfoForm courseInfoForm);

    CourseInfoForm getCourseInfoFormById(String id);

    void updateCourseInfoById(CourseInfoForm courseInfoForm);

    CoursePublishVo getCoursePublishVoById(String id);

    void publishCourseById(String id);

    void pageQuery(Page<Course> pageParam, CourseQuery courseQuery);

    boolean del(String id);
}
