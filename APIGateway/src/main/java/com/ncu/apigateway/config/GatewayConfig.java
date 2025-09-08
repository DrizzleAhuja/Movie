package com.ncu.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // Route for Movie service
                .route("movie_route", r -> r.path("/movies/**")
                        .uri("lb://MOVIESERVICE")) // Use load-balancer and service name
                // Route for Review service
                .route("review_route", r -> r.path("/reviews/**")
                        .uri("lb://REVIEWSYSTEM")) // Use load-balancer and service name
                // Route for MovieDetails service
                .route("moviedetails_route", r -> r.path("/moviedetails/**")
                        .uri("lb://MOVIEDETAILSSYSTEM")) // Use load-balancer and service name
                // Route for Ticket service
                .route("ticket_route", r -> r.path("/tickets/**")
                        .uri("lb://TICKETSERVICE")) // Use load-balancer and service name
                .build();
    }
}
