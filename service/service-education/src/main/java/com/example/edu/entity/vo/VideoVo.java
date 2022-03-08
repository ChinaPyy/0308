package com.example.edu.entity.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 创建人:楚克旺
 * 创建时间:2022/1/17 8:59
 **/

@ApiModel(value = "课时信息")
@Data
public class VideoVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String title;
    private Boolean free;
    private String videoOriginalName;
}