package com.mongo.product.mongo.docker.service;

import com.mongo.product.mongo.docker.model.Product;
import com.mongo.product.mongo.docker.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public Product updateProduct(String id, Product product) {
        product.setId(id);
        return repository.save(product);
    }

    public void deleteProduct(String id) {
        repository.deleteById(id);
    }
}
