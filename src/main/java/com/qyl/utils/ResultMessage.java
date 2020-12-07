package com.qyl.utils;

import lombok.Data;

/**
 * @Author: qyl
 * @Date: 2020/12/7 9:56
 */
@Data
public class ResultMessage {

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private Object data;

    public static ResultMessage success(int code, String msg) {
        return response(code, msg, null);
    }

    public static ResultMessage success(int code, String msg, Object data) {
        return response(code, msg, data);
    }

    public static ResultMessage fail(int code, String msg) {
        return response(code, msg, null);
    }

    public static ResultMessage response(int code, String msg, Object data) {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setCode(code);
        resultMessage.setMsg(msg);
        resultMessage.setData(data);
        return resultMessage;
    }
}
