package com.example.edu.entity.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 创建人:楚克旺
 * 创建时间:2022/1/17 20:06
 **/
@ApiModel(value = "课程发布信息")
@Data
public class CoursePublishVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private String cover;
    private Integer lessonNum;
    private String subjectLevelOne;
    private String subjectLevelTwo;
    private String teacherName;
    private String price;//只用于显示

}
