package com.diya.microservices.product.repository;

import com.diya.microservices.product.dto.ProductResponse;
import com.diya.microservices.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;


public interface ProductRepository extends MongoRepository<Product, String> {
    @Query("{'name': ?0}")
    Product getProductByName(String name);
}
