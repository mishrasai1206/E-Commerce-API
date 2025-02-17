package com.example.ecom.serviceimpl;

import com.example.ecom.exception.CartItemNotFoundByIdException;
import com.example.ecom.exception.IllegalOperationException;
import com.example.ecom.exception.ProductNotFoundByIdException;
import com.example.ecom.model.CartItem;
import com.example.ecom.model.Customer;
import com.example.ecom.model.Product;
import com.example.ecom.model.User;
import com.example.ecom.repository.CartItemRepository;
import com.example.ecom.repository.ProductRepository;
import com.example.ecom.repository.UserRepository;
import com.example.ecom.service.CartItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;


    @Override
    public CartItem createCartItem(String productId, String customerId, int quantity) {
       User user =  userRepository.findById(customerId).orElseThrow();

        if (user instanceof Customer customer) {
            return productRepository.findById(productId)
                    .map(product -> {
                        CartItem cartItem = new CartItem();
                        cartItem.setQuantity(quantity);
                        cartItem.setPrice(product.getPrice() * quantity);

                        return cartItemRepository.save(cartItem);
                    }).orElseThrow(() ->new ProductNotFoundByIdException("Failed to find the product"));
        } else
            throw new IllegalOperationException("Failed to save product");
    }

    // TODO: Have to validate the Users ownership before updating the cartItem
    @Override
    public CartItem updateCartItem(String id, int quantity) {
        return cartItemRepository.findById(id)
                .map(cartItem -> {
                    int exQuantity = cartItem.getQuantity();
                    cartItem.setQuantity(quantity);
                    cartItem.setPrice(cartItem.getPrice()/exQuantity * quantity);

                    return cartItemRepository.save(cartItem);
                }).orElseThrow(()-> new CartItemNotFoundByIdException("Failed to find the CartItem"));
    }
}
