package com.productApp.controller;

import com.productApp.dto.ErrorMessage;
import com.productApp.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class AppExHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorMessage> handle404(ProductNotFoundException ex){
        System.out.println("------------------------------------------");
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage(ex.getMessage());
        errorMessage.setStatusCode(HttpStatus.NOT_FOUND.toString());
        errorMessage.setLocalDateTime(LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handle500(Exception ex){
        System.out.println("------------------------------------------");
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage("Please try after some time!!");
        errorMessage.setStatusCode(HttpStatus.NOT_FOUND.toString());
        errorMessage.setLocalDateTime(LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }
}
