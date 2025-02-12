package com.example.ecom.exceptionhandler;

import com.example.ecom.util.ErrorStructure;
import com.example.ecom.util.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class GeneralExceptionHandler {

    private final RestResponseBuilder responseBuilder;

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorStructure<String>> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        return responseBuilder.error(HttpStatus.BAD_REQUEST, "Invalid Input", ex.getMessage());
    }
}
