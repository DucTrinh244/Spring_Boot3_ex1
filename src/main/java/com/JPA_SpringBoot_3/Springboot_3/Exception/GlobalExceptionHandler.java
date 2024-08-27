package com.JPA_SpringBoot_3.Springboot_3.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// DEFILE EXCEPTION
@ControllerAdvice
public class GlobalExceptionHandler {


    // exception RuntimeException
    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<String> handlingRuntimeException(RuntimeException exception){
        // lỗi 400 thì sử dụng badRequest
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    // bắt exception MethodArgumentNotValidException trong validation
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<String> handlingMehtodArgummetValideException(MethodArgumentNotValidException exception){
        // lỗi 400 thì sử dụng badRequest
        return ResponseEntity.badRequest().body(exception.getFieldError().getDefaultMessage());
    }



}
