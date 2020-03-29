package com.entertainment.test.base;

public class BadParamsException extends RuntimeException {

    private String message = "请求参数错误";

    public BadParamsException() {

    }

    public BadParamsException(String info) {
        this.message = info;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}