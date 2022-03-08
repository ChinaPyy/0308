package com.example.controller;


import com.example.service.VodService;
import com.example.utlis.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(description="阿里视频")
@RestController
@RequestMapping("/vod/video")
@CrossOrigin
public class VodController {

    @Autowired
    private VodService vodService;

    //上传视频到阿里云
    @PostMapping("uploadAlyiVideo")
    public R uploadAlyiVideo(MultipartFile file) {
        //返回上传视频id
        String videoId = vodService.uploadVideoAly(file);
        return R.ok().data("videoId",videoId);
    }

    @DeleteMapping("{videoId}")
    public R removeVideo(@ApiParam(name = "videoId", value = "云端视频id", required = true)
        @PathVariable String videoId){
        vodService.removeVideo(videoId);
        return R.ok().message("视频删除成功");
    }

}
