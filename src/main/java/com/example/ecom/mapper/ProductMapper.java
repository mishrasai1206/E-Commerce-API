package com.example.ecom.mapper;

import com.example.ecom.dto.request.ProductRequest;
import com.example.ecom.dto.response.ProductResponse;
import com.example.ecom.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product mapToProduct(ProductRequest productRequest);

    ProductResponse mapToProductResponse(Product product);
}
