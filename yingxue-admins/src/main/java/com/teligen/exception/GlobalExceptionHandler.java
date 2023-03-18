package com.teligen.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liangtao
 * @date 2023-03-18 22:19
 * @desc: 全局异常处理Handler
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    //自定义异常处理,处理所有的controller异常
    @ExceptionHandler
    public Map<String,String> exception(Exception exception){
        String message = exception.getMessage();
        log.info("ex:{}", message);
        Map<String,String>resultMap=new HashMap<>();
        resultMap.put("msg", message);
        return resultMap;
    }

}
