package com.example.controller;

import com.example.service.OssService;
import com.example.utlis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 创建人:楚克旺
 * 创建时间:2022/1/13 16:10
 **/

@Api(description = "阿里云文件管理")
@CrossOrigin //跨域
@RestController
@RequestMapping("/oss")
public class OssController {

    @Autowired
    private OssService ossService;

    /**
     * 文件上传
     *
     * @param file
     */
    @ApiOperation(value = "文件上传")
    @PostMapping("upload")
    public R upload(
            @ApiParam(name = "file", value = "文件", required = true)
                    MultipartFile file) {
        String uploadUrl = ossService.upload(file);
        //返回r对象
        return R.ok().message("文件上传成功").data("url", uploadUrl);
    }
}
