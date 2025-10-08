package com.mongo.product.mongo.docker.repository;

import com.mongo.product.mongo.docker.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}
