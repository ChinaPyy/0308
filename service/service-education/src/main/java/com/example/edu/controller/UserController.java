package com.example.edu.controller;

import com.example.edu.entity.Teacher;
import com.example.edu.service.TeacherService;
import com.example.utlis.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建人:楚克旺
 * 创建时间:2022/1/12 22:19
 **/
@CrossOrigin //跨域
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private TeacherService teacherService;

    @PostMapping("/login")
    public R login() {
        return R.ok().data("token", "admin");
    }

    @GetMapping("/info")
    public R info() {
        return R.ok().data("roles", "[admin]").data("name", "admin").data("avatar", "https://to-you.oss-cn-beijing.aliyuncs.com/avatar/mrtx.jpeg");
    }

}
