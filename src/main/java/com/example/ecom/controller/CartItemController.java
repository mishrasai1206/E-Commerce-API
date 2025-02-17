package com.example.ecom.controller;

import com.example.ecom.model.CartItem;
import com.example.ecom.service.CartItemService;
import com.example.ecom.service.CartItemsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.ecom.model.CartItems;
import com.example.ecom.util.ResponseStructure;
import com.example.ecom.util.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;

@RestController
@AllArgsConstructor
public class CartItemController {
    private final CartItemService cartItemService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/cart-items/customers/{customerId}/products/{productId}")
    public ResponseEntity<ResponseStructure<CartItem>> createCartItem(@PathVariable String productId, @PathVariable String customerId, @RequestParam int quantity) {
        CartItem createdCartItem = cartItemService.createCartItem(productId, customerId, quantity);
        return responseBuilder.success(HttpStatus.CREATED, "Cart item created successfully", createdCartItem);
    }

    @PatchMapping("/cart-items/{id}")
    public ResponseEntity<ResponseStructure<CartItem>> updateCartById(@PathVariable String id, int quantity){
        CartItem cartItem = cartItemService.updateCartItem(id, quantity);
        return responseBuilder.success(HttpStatus.OK, "Cart item updated successfully", cartItem);
    }
}