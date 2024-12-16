package com.diya.microservices.product.controller;

import com.diya.microservices.product.dto.ProductRequest;
import com.diya.microservices.product.dto.ProductResponse;
import com.diya.microservices.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
//        log.info("Creating product {}", productRequest);
        log.debug("Creating Debug Log ");
        log.error("Creating Error Log ");
        log.trace("Creating Trace Log ");
        log.info("Creating Info Log ");
        log.warn("Creating Warn Log ");
        return productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProduct();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse updateProduct(@RequestBody ProductRequest productRequest) {
        return productService.updateProduct(productRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse getProductByName(@PathVariable String name) {
        return productService.getProductByName(name);
    }
}
