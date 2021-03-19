package com.qyl.exception;

/**
 * @Author: qyl
 * @Date: 2021/3/19 16:56
 * @Description: 响应异常类
 */
public class ResponseException extends RuntimeException {

    /**
     * 异常响应码
     */
    private int code;

    /**
     * 异常信息
     */
    private String msg;

    public ResponseException(String message, int code, String msg) {
        super(message);
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
