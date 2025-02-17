package com.example.ecom.exception.handlers;

import com.example.ecom.exception.CartItemNotFoundByIdException;
import com.example.ecom.util.ErrorStructure;
import com.example.ecom.util.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class CartItemHandler {

    private RestResponseBuilder responseBuilder;

    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> handleCartItemNotFoundById(CartItemNotFoundByIdException ex){
        return responseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "CartItem not found by given id");
    }
}
