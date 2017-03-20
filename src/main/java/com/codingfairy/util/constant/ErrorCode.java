package com.codingfairy.util.constant;

/**
 * error code constant
 */
public enum ErrorCode {

    SUCCESS(200,"操作成功"),
    USER_NOT_FOUND(420,"用户名不存在。"),
    ERROR_PASSWORD(430,"密码错误");

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }
}
