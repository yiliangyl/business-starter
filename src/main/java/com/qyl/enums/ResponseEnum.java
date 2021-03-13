package com.qyl.enums;

/**
 * @Author: qyl
 * @Date: 2020/12/7 9:54
 */
public enum ResponseEnum {
    SUCCESS(1, "成功"),
    FAIL(0, "失败"),

    // 用户模块错误
    USER_EXIST(1001, "用户已存在"),
    CODE_IS_INCORRECT(1002, "验证码不正确"),
    LOGIN_ERROR(1003, "手机号或密码错误"),
    TOKEN_ERROR(1004, "token出错"),
    ;

    /**
     * 状态码
     */
    private int code;

    /**
     * 状态信息
     */
    private String msg;

    ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
