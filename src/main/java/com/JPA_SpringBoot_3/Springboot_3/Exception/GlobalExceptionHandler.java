package com.JPA_SpringBoot_3.Springboot_3.Exception;

import com.JPA_SpringBoot_3.Springboot_3.dto.request.APIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// DEFILE EXCEPTION
@ControllerAdvice
public class GlobalExceptionHandler {


    // Get Exception remaining : Bắt các exception còn lại và hiển thị ra lỗi
    @ExceptionHandler(value = Exception.class)
    ResponseEntity<APIResponse> handlingException(Exception exception){
        APIResponse apiResponse= new APIResponse();

        apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
        apiResponse.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());
        // bắt lại tất cả các lỗi được định sẵn
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<APIResponse> handlingAppException(AppException exception){
        // get Errorcode được truyền vào từ class AppException
        ErrorCode errorCode= exception.getErrorCode();

        APIResponse apiResponse= new APIResponse();

        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());
        // lỗi 400 thì sử dụng badRequest
        return ResponseEntity.badRequest().body(apiResponse);
    }

    // bắt exception MethodArgumentNotValidException trong validation
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<APIResponse> handlingMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        // lỗi 400 thì sử dụng badRequest
        String enumKey =exception.getFieldError().getDefaultMessage();

        ErrorCode errorCode = ErrorCode.INVALID_KEY;

        try {
            errorCode = ErrorCode.valueOf(enumKey);
        } catch (IllegalArgumentException e){

        }
        APIResponse apiResponse= new APIResponse();

        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());

        return ResponseEntity.badRequest().body(apiResponse);
    }



}
