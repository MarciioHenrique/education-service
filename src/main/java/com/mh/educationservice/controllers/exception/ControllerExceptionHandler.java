package com.mh.educationservice.controllers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> genericException(Exception ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .timestamp(LocalDateTime.now())
                .code(status.value())
                .status(status.name())
                .error(ex.getMessage())
                .build();
        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> illegalArgumentException(IllegalArgumentException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .timestamp(LocalDateTime.now())
                .code(status.value())
                .status(status.name())
                .error(ex.getMessage())
                .build();
        return new ResponseEntity<>(errorResponse, status);
    }
}
