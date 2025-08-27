package com.ncu.Ticket.irepo;

import com.ncu.Ticket.dto.TicketDTO;
import java.util.List;

public interface ITicketRepository {
    List<TicketDTO> getAllTickets();
    void addTicket(TicketDTO ticketDTO);
}
