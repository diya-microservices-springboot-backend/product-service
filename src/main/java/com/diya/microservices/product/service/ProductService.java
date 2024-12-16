package com.diya.microservices.product.service;

import com.diya.microservices.product.dto.ProductRequest;
import com.diya.microservices.product.dto.ProductResponse;
import com.diya.microservices.product.model.Product;
import com.diya.microservices.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();

        productRepository.save(product);
        log.info("Created product Successfully : {}", product);
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    public List<ProductResponse> getAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice()))
                .toList();
    }

    public ProductResponse updateProduct(ProductRequest productRequest) {
        final Product product = productRepository.findById(productRequest.id())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(productRequest.name());
        product.setDescription(productRequest.description());
        product.setPrice(productRequest.price());

        productRepository.save(product);
        log.info("Updated product Successfully : {}", product);
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice());
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id.toString());
    }

    public ProductResponse getProductByName(String name) {
        Product product = productRepository.getProductByName(name);
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice());
    }
}
