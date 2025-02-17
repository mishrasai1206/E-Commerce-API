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
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/users/{userId}/products")
    public ResponseEntity<ResponseStructure<ProductResponse>> saveProduct(@PathVariable String userId, @RequestBody ProductRequest productRequest) {
        ProductResponse response = productService.saveProduct(userId, productRequest);
        return responseBuilder.success(HttpStatus.CREATED, "Product Created successfully", response);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<ResponseStructure<ProductResponse>> findProductById(@PathVariable String productId){
        ProductResponse response = productService.findProductById(productId);
        return responseBuilder.success(HttpStatus.FOUND,"Product found successfully", response );
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<ResponseStructure<ProductResponse>> updateProductById(@PathVariable String productId, @RequestBody ProductRequest productRequest){
        ProductResponse response = productService.updateProductById(productId,productRequest);
        return responseBuilder.success(HttpStatus.OK, "Product updated successfully", response);
    }
}
