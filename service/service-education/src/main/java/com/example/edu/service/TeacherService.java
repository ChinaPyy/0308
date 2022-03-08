package com.example.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.edu.query.TeacherQuery;

import java.util.List;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-01-11
 */
public interface TeacherService extends IService<Teacher> {
    void pageQuery(Page<Teacher> pageParam, TeacherQuery teacherQuery);

}
