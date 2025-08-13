package com.ncu.Ticket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/Ticket")
@RestController
public class TicketController {

    /*
     * Example: http://localhost:9002/Ticket/ticket
     */
    @GetMapping(path = "/ticket")
    public String getAllTickets() {
        System.out.println("Hello from ticket controller!");
        return "Hello from ticket controller!";
    }

    /*
     * Example: http://localhost:9002/Ticket/ticket/Inception
     */
    @GetMapping(path = "/ticket/{title}")
    public String getTicketByTitle(@PathVariable("title") String title) {
        System.out.println("Fetching ticket: " + title);
        return "Fetching ticket: " + title;
    }
}