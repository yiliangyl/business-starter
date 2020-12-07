package com.qyl.exception;

import com.qyl.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author: qyl
 * @Date: 2020/12/7 9:58
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MyException extends RuntimeException {

    private ExceptionEnum exceptionEnum;
}
