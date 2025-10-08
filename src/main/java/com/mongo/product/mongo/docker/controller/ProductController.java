package com.mongo.product.mongo.docker.controller;

import com.mongo.product.mongo.docker.model.Product;
import com.mongo.product.mongo.docker.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "Find all products")
    public List<Product> getAll() {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find product by id")
    public Product getById(@PathVariable String id) {
        return service.getProductById(id);
    }

    @PostMapping
    @Operation(summary = "Create new product")
    public Product create(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update product")
    public Product update(@PathVariable String id, @RequestBody Product product) {
        return service.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete product by id")
    public void delete(@PathVariable String id) {
        service.deleteProduct(id);
    }
}
