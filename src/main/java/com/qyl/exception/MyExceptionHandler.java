package com.qyl.exception;

import com.qyl.enums.ExceptionEnum;
import com.qyl.utils.ResultMessage;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: qyl
 * @Date: 2020/12/7 9:59
 */
@ControllerAdvice
@ResponseBody
public class MyExceptionHandler {

    /**
     * 通用异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(MyException.class)
    public ResultMessage handlerException(MyException e) {
        ExceptionEnum exceptionEnum = e.getExceptionEnum();
        return ResultMessage.fail(exceptionEnum.getCode(), exceptionEnum.getMsg());
    }
}
