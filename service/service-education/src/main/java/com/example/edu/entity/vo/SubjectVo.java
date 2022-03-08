package com.example.edu.entity.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建人:楚克旺
 * 创建时间:2022/1/14 14:39
 **/
@Data
public class SubjectVo {
    private String id;
    private String title;
    private List<SubjectVo> children = new ArrayList<>();
}
