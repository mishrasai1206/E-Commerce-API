package com.example.ecom.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CartItemNotFoundByIdException extends RuntimeException {
    private String message;
}
