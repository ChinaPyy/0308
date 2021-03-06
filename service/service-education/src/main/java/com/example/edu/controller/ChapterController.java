package com.example.edu.controller;


import com.example.edu.entity.Chapter;
import com.example.edu.entity.vo.ChapterVo;
import com.example.edu.service.ChapterService;
import com.example.utlis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-01-14
 */
@Api(description = "课程章节管理")
@CrossOrigin
@RestController
@RequestMapping("/edu/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @ApiOperation(value = "嵌套章节数据列表")
    @GetMapping("nested-list/{courseId}")
    public R nestedListByCourseId(
            @ApiParam(name = "courseId", value = "课程ID", required = true)
            @PathVariable String courseId) {
        List<ChapterVo> chapterVoList = chapterService.nestedList(courseId);
        return R.ok().data("items", chapterVoList);
    }

    @ApiOperation(value = "新增章节")
    @PostMapping
    public R save(
            @ApiParam(name = "chapterVo", value = "章节对象", required = true)
            @RequestBody Chapter chapter) {
        chapterService.save(chapter);
        return R.ok();
    }

    @ApiOperation(value = "根据ID查询章节")
    @GetMapping("{id}")
    public R getById(
            @ApiParam(name = "id", value = "章节ID", required = true)
            @PathVariable String id) {
        Chapter chapter = chapterService.getById(id);
        return R.ok().data("item", chapter);
    }

    @ApiOperation(value = "根据ID修改章节")
    @PutMapping("{id}")
    public R updateById(
            @ApiParam(name = "id", value = "章节ID", required = true)
            @PathVariable String id,
            @ApiParam(name = "chapter", value = "章节对象", required = true)
            @RequestBody Chapter chapter) {
        chapter.setId(id);
        chapterService.updateById(chapter);
        return R.ok();
    }

    @ApiOperation(value = "根据ID删除章节")
    @DeleteMapping("{id}")
    public R removeById(
            @ApiParam(name = "id", value = "章节ID", required = true)
            @PathVariable String id) {
        boolean result = chapterService.removeChapterById(id);
        if (result) {
            return R.ok();
        } else {
            return R.error().message("删除失败");
        }
    }
}