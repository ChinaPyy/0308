package com.example.edu;

import com.example.utlis.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 创建人:楚克旺
 * 创建时间:2022/2/14 10:11
 **/
@FeignClient("service-vod")
@Component
public interface VodClient {

    @DeleteMapping(value = "/eduvod/vod/video/{videoId}")
    R removeVideo(@PathVariable("videoId") String videoId);

}
