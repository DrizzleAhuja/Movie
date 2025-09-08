package com.ncu.Ticket.irepo;

import com.ncu.Ticket.model.Ticket;
import java.util.List;

public interface ITicketRepository {
    List<Ticket> getAllTickets();
    List<Ticket> getTicketsByMovieId(String movieId);
    void addTicket(Ticket ticket);
}
