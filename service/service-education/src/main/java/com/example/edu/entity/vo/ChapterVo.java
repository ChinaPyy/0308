package com.example.edu.entity.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建人:楚克旺
 * 创建时间:2022/1/17 8:53
 **/
@ApiModel(value = "章节信息")
@Data
public class ChapterVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String title;
    private List<VideoVo> children = new ArrayList<>();
}
