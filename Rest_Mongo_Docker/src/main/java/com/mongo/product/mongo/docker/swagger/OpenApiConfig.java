package com.mongo.product.mongo.docker.swagger;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI productApiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("Product API with MongoDB")
                        .version("1.0")
                        .description("Spring Boot REST API using MongoDB"));
    }
}
