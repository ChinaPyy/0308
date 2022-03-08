package com.example.handler;

import com.example.utlis.ExceptionUtil;
import com.example.utlis.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 创建人:楚克旺
 * 创建时间:2022/1/11 18:05
 **/
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        e.printStackTrace();
//        log.error(e.getMessage());
//        log.error(ExceptionUtil.getMessage(e));
        return R.error();
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e) {
        e.printStackTrace();
//        log.error(e.getMessage());
//        log.error(ExceptionUtil.getMessage(e));
        return R.error().message("执行了自定义异常");
    }

    @ExceptionHandler(GuliException.class)
    @ResponseBody
    public R error(GuliException e) {
        e.printStackTrace();
//        log.error(e.getMessage());
//        log.error(ExceptionUtil.getMessage(e));
        return R.error().message(e.getMsg()).code(e.getCode());

    }
}

