package com.edusubmit.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRouteConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("student-service-route", r -> r.path("/student/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://student-service"))
                .route("submission-service-route", r -> r.path("/submission/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://submission-service"))
                .route("file-service-route", r -> r.path("/file/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://file-service"))
                .build();
    }
}
