package com.example.ecom.serviceimpl;

import com.example.ecom.dto.request.ProductRequest;
import com.example.ecom.dto.response.ProductResponse;
import com.example.ecom.enums.UserRole;
import com.example.ecom.exception.IllegalOperationException;
import com.example.ecom.exception.ProductNotFoundByIdException;
import com.example.ecom.mapper.ProductMapper;
import com.example.ecom.model.Product;
import com.example.ecom.model.Seller;
import com.example.ecom.model.User;
import com.example.ecom.repository.ProductRepository;
import com.example.ecom.repository.UserRepository;
import com.example.ecom.service.ProductService;
import com.example.ecom.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponse saveProduct(String userId, ProductRequest productRequest) {
        return userRepository.findById(userId)
                .map(user -> {
                    if (user instanceof Seller seller) {
                        Product product = productMapper.mapToProduct(productRequest);
                        product.setSeller(seller);
                        productRepository.save(product);
                        return productMapper.mapToProductResponse(product);
                    } else
                        throw new IllegalOperationException("Failed to find product.");
                })
                .orElseThrow(() -> new ProductNotFoundByIdException("Failed to find the Product"));
    }
}
