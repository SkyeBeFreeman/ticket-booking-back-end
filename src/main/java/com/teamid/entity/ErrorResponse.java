package com.teamid.entity;

/**
 * Created by 伟宸 on 2017/6/3.
 */
public class ErrorResponse {
    int code;
    String message;

    public ErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {

        return code;
    }

    public String getMessage() {
        return message;
    }
}
