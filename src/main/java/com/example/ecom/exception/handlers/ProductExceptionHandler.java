package com.example.ecom.exception.handlers;

import com.example.ecom.exception.IllegalOperationException;
import com.example.ecom.exception.ProductNotFoundByIdException;
import com.example.ecom.exception.UserNotFoundByIdException;
import com.example.ecom.model.Product;
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
public class ProductExceptionHandler {
    private final RestResponseBuilder responseBuilder;

    public ResponseEntity<ErrorStructure<String>>  handleProductNotFoundById(ProductNotFoundByIdException ex){
        return responseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "Product Not found by the given id");
    }
}
