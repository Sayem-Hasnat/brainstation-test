package com.hasnat.bs23.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.ConnectException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<String> connectException(ConnectException connectException) {
        return new ResponseEntity<>(connectException.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

