package com.roche.exam.FizzBuzz.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class FizzBuzzExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class, ConstraintViolationException.class})
    public ResponseEntity<ErrorResponse> handleBadRequestException(RuntimeException exp, WebRequest request) {
        String responseBody = new BadRequestException(exp.getLocalizedMessage()).toString();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(responseBody));
    }
}
