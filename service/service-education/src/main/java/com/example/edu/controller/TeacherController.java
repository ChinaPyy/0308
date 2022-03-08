package com.example.edu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.edu.entity.Teacher;
import com.example.edu.query.TeacherQuery;
import com.example.edu.service.TeacherService;
import com.example.utlis.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-01-11
 */

@RestController
@RequestMapping("/edu/teacher")
@CrossOrigin //跨域
public class TeacherController {
    @Resource
    private TeacherService teacherService;

    //全查
    @ApiOperation(value = "所有讲师列表")
    @GetMapping
    public R list() {
        List<Teacher> list = teacherService.list(null);
        return R.ok().data("items", list);
    }

//    @ApiOperation(value = "根据ID删除讲师")
//    @DeleteMapping("{id}")
//    public R removeById(
//            @ApiParam(name = "id", value = "讲师ID", required = true)
//            @PathVariable Long id) {
//        teacherService.removeById(id);
//        return R.ok();
//    }

    //2 逻辑删除讲师的方法
    @ApiOperation(value = "逻辑删除讲师")
    @DeleteMapping("{id}")
    public R removeTeacher(@ApiParam(name = "id", value = "讲师ID", required = true)
                           @PathVariable Long id) {
        boolean flag = teacherService.removeById(id);
        if (flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @ApiOperation(value = "分页讲师列表")
    @PostMapping("{page}/{limit}")
    public R pageQuery(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "teacherQuery", value = "查询对象", required = false)
            @RequestBody TeacherQuery teacherQuery) {
        Page<Teacher> pageParam = new Page<>(page, limit);
        String name = teacherQuery.getName();
        System.out.println(name);
        teacherService.pageQuery(pageParam, teacherQuery);
        List<Teacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "新增讲师")
    @PostMapping
    public R save(
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody Teacher teacher) {
        System.out.println(teacher.toString());
        teacherService.save(teacher);
        return R.ok();
    }

    @ApiOperation(value = "根据ID查询")
    @GetMapping("{id}")
    public R getById(@PathVariable String id) {
        Teacher byId = teacherService.getById(id);
        return R.ok().data("obj", byId);
    }

    @ApiOperation(value = "根据ID修改讲师")
    @PutMapping("{id}")
    public R updateById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable Long id,
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody Teacher teacher) {
        teacher.setId(id);
        teacherService.updateById(teacher);
        return R.ok();
    }
}

