package com.book_service.book_service.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

public class GroupApiConfig {
    @Bean
    public GroupedOpenApi bookApi() {
        return GroupedOpenApi.builder()
                .group("books")
                .pathsToMatch("/api/v1/books/**")
                .build();
    }

    @Bean
    public GroupedOpenApi categoryApi() {
        return GroupedOpenApi.builder()
                .group("categories")
                .pathsToMatch("/api/v1/categories/**")
                .build();
    }

}
