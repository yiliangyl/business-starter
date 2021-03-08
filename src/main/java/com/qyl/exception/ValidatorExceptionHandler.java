package com.qyl.exception;

import com.qyl.enums.ResponseEnum;
import com.qyl.utils.ResponseResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * @Author: qyl
 * @Date: 2021/2/5 13:41
 * @Description:
 */
@RestControllerAdvice
public class ValidatorExceptionHandler {

    /**
     * 处理校验异常（注解加在普通参数）
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseResult<Void> validatorException(ConstraintViolationException e) {
        // 获取校验信息集合
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
            String msg = constraintViolation.getMessage();
            if (StringUtils.isNotEmpty(msg)) {
                return ResponseResult.fail(ResponseEnum.FAIL.getCode(), msg);
            }
        }
        return ResponseResult.fail();
    }
}
