package com.qyl.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: qyl
 * @Date: 2020/12/7 9:54
 */
@Getter
@AllArgsConstructor
public enum ResponseEnum {
    SUCCESS(1, "成功"),
    FAIL(0, "失败"),
    ;

    /**
     * 状态码
     */
    private final int code;

    /**
     * 状态信息
     */
    private final String msg;
}
