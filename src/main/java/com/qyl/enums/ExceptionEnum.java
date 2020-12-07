package com.qyl.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: qyl
 * @Date: 2020/12/7 9:54
 */
@Getter
@AllArgsConstructor
public enum ExceptionEnum {

    ;

    /**
     * 错误码
     */
    private int code;

    /**
     * 错误信息
     */
    private String msg;
}
