package com.cloudGateway.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.reactive.CorsWebFilter;

@Configuration
public class SpringCloudConfig {


    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r -> r.path("/users/**")
//                .filters(f -> f.addResponseHeader("second-request", "second-request-header")
//                    .addResponseHeader("second-response", "second-response-header"))
                        .uri("http://localhost:8081/")
                        .id("userService"))

                .route(r -> r.path("/posts/**")
                        .uri("http://localhost:8082/")
                        .id("postService"))

                .route(r -> r.path("/auth/**")
                        .uri("http://localhost:8083/")
                        .id("securityService"))
                .build();
    }
}
