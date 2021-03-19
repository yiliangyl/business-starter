package com.qyl.exception;

import com.qyl.utils.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: qyl
 * @Date: 2021/3/19 16:58
 * @Description: 全局异常处理类
 */
@RestControllerAdvice
public class ExceptionAdvice {

    /**
     * 处理响应异常
     * @param e
     * @return
     */
    @ExceptionHandler(ResponseException.class)
    public ResponseResult<Void> responseExceptionHandler(ResponseException e) {
        return ResponseResult.fail(e.getCode(), e.getMsg());
    }
}
