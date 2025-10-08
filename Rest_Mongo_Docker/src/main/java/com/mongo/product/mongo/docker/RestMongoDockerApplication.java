package com.mongo.product.mongo.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestMongoDockerApplication {

	public static void main(String[] args) {
		System.out.println("abc");
		SpringApplication.run(RestMongoDockerApplication.class, args);
	}

}
