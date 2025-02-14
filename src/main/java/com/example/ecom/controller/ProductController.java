package com.example.ecom.controller;

import com.example.ecom.dto.request.ProductRequest;
import com.example.ecom.dto.response.ProductResponse;
import com.example.ecom.model.Product;
import com.example.ecom.service.ProductService;
import com.example.ecom.util.ResponseStructure;
import com.example.ecom.util.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final RestResponseBuilder responseBuilder;

    public ResponseEntity<ResponseStructure<ProductResponse>> saveProduct(@PathVariable String userId, @RequestBody ProductRequest productRequest){
        ProductResponse response = productService.saveProduct(userId,productRequest);
        return responseBuilder.success(HttpStatus.CREATED,"Product Created successfully", response);
    }
}
