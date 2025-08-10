package com.diya.microservices.product.service;

import com.diya.microservices.product.dto.ProductRequest;
import com.diya.microservices.product.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProduct();

    ProductResponse updateProduct(ProductRequest productRequest);

    void deleteProduct(Long id);

    ProductResponse getProductByName(String name);
}
