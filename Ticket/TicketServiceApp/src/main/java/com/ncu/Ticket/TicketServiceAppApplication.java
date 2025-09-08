package com.ncu.Ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TicketServiceAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(TicketServiceAppApplication.class, args);
    }
}
