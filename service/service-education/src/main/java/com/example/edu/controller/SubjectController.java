package com.example.edu.controller;


import com.example.edu.entity.vo.SubjectVo;
import com.example.edu.service.SubjectService;
import com.example.utlis.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-01-14
 */
@CrossOrigin
@RestController
@RequestMapping("/edu/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    //添加课程分类
    @ApiOperation(value = "Excel批量导入")
    @PostMapping("addSubject")
    public R addSubject(MultipartFile file) {
        //1 获取上传的excel文件 MultipartFile
        //返回错误提示信息
        subjectService.importSubjectData(file, subjectService);
        //判断返回集合是否为空
        return R.ok();
    }

    @ApiOperation(value = "嵌套数据列表")
    @GetMapping
    public R nestedList() {
        List<SubjectVo> subjectNestedVoList = subjectService.nestedList();
        return R.ok().data("items", subjectNestedVoList);
    }
}


