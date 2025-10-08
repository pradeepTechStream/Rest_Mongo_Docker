package com.mongo.product.mongo.docker.repository;

import com.mongo.product.mongo.docker.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
