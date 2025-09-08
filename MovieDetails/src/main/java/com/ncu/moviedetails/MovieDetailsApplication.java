package com.ncu.moviedetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MovieDetailsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieDetailsApplication.class, args);
    }
}
