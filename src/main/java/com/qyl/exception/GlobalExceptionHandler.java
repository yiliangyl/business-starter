package com.qyl.exception;

import com.qyl.enums.ResponseEnum;
import com.qyl.utils.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * @Author: qyl
 * @Date: 2021/2/5 13:41
 * @Description:
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Void> validatorErrorHandler(MethodArgumentNotValidException ex) {
        ObjectError objectError = ex.getBindingResult().getAllErrors().get(0);
        return ResponseEntity.error(ResponseEnum.FAIL.getCode(), objectError.getDefaultMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Void> validatorErrorHandler(ConstraintViolationException ex) {
//        String msg = ex.getMessage().split(": ")[1];
        String msg = ex.getMessage();
        return ResponseEntity.error(ResponseEnum.FAIL.getCode(), msg);
    }
}
