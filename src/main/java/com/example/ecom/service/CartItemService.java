package com.example.ecom.service;

import com.example.ecom.model.CartItem;

public interface CartItemService {
    public CartItem createCartItem(String productId,String customerId, int quantity);

    public CartItem updateCartItem(String id, int quantity);
}
