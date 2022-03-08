package com.example.edu.service;

import com.example.edu.entity.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.edu.entity.vo.SubjectVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-01-14
 */
public interface SubjectService extends IService<Subject> {

    void importSubjectData(MultipartFile file, SubjectService subjectService);

    List<SubjectVo> nestedList();
}
