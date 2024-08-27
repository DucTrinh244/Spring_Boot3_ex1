package com.JPA_SpringBoot_3.Springboot_3.dto.request;


import com.fasterxml.jackson.annotation.JsonInclude;

// CREATE CONTRUCTOR FOR API RESPONSE
// KẾT QUẢ TRẢ VỀ THEO CẤU TRÚC ĐƯỢC CHỈ ĐỊNH
@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIResponse <T> {
    private int code =1000;
    private String message;
    private T result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }


}
