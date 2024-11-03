package com.JPA_SpringBoot_3.Springboot_3.Exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999,"Uncategorized Exception !"),
    USER_EXIST(1002,"User Existed !"),
    INVALID_KEY(1001,"Invalid Valid Key"),
    USERNAME_INVALID(1003, "Username must be at least 3 characters !"),
    PASSWORD_INVALID(1004, "Password must be at least 8 characters !"),
    USER_NOT_EXIST(1005,"User Not Existed !"),

    ;
    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
