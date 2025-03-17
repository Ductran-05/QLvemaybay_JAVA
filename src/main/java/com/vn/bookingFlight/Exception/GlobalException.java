package com.vn.bookingFlight.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vn.bookingFlight.dto.response.APIResponse;

@RestControllerAdvice
public class GlobalException {
    // xu ly exception thong thuong
    @ExceptionHandler(value = AppException.class)
    ResponseEntity<APIResponse<String>> handleAppException(AppException exception) {
        APIResponse<String> response = new APIResponse<>();
        response.setMessage(exception.getErrorCode().getMessage());
        response.setCode(exception.getErrorCode().getCode());
        return ResponseEntity.badRequest().body(response);
    }

}
