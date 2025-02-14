package com.example.ecom.service;

import com.example.ecom.dto.request.ProductRequest;
import com.example.ecom.dto.response.ProductResponse;

public interface ProductService {
    public ProductResponse saveProduct(String userId, ProductRequest productRequest);
}
