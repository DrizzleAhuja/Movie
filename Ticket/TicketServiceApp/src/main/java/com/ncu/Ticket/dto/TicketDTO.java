package com.ncu.Ticket.dto;

public class TicketDTO {
    private String ticketId;
    private String ticketName;

    public TicketDTO() {}

    public TicketDTO(String ticketId, String ticketName) {
        this.ticketId = ticketId;
        this.ticketName = ticketName;
    }

    public String getTicketId() { return ticketId; }
    public void setTicketId(String ticketId) { this.ticketId = ticketId; }
    public String getTicketName() { return ticketName; }
    public void setTicketName(String ticketName) { this.ticketName = ticketName; }
}
