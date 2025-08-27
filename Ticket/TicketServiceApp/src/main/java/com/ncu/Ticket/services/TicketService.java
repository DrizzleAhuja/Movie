package com.ncu.Ticket.services;

import com.ncu.Ticket.irepo.ITicketRepository;
import com.ncu.Ticket.dto.TicketDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    private ITicketRepository ticketRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<TicketDTO> getAllTickets() {
        return ticketRepository.getAllTickets();
    }

    public void addTicket(TicketDTO ticketDTO) {
        ticketRepository.addTicket(ticketDTO);
    }
}
