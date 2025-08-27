package com.ncu.Ticket.model;

public class Ticket {
    private String ticketId;
    private String movieId;
    private String userId;
    private int seatNumber;

    public Ticket() {}

    public Ticket(String ticketId, String movieId, String userId, int seatNumber) {
        this.ticketId = ticketId;
        this.movieId = movieId;
        this.userId = userId;
        this.seatNumber = seatNumber;
    }

    public String getTicketId() { return ticketId; }
    public void setTicketId(String ticketId) { this.ticketId = ticketId; }
    public String getMovieId() { return movieId; }
    public void setMovieId(String movieId) { this.movieId = movieId; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public int getSeatNumber() { return seatNumber; }
    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }
}
