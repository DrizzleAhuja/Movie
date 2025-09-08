package com.ncu.Ticket.services;

import com.ncu.Ticket.irepo.ITicketRepository;
import com.ncu.Ticket.dto.TicketDTO;
import com.ncu.Ticket.model.Ticket;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {
    @Autowired
    private ITicketRepository ticketRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<TicketDTO> getAllTickets() {
        List<Ticket> tickets = ticketRepository.getAllTickets();
        return tickets.stream()
                .map(t -> modelMapper.map(t, TicketDTO.class))
                .collect(Collectors.toList());
    }

    public List<TicketDTO> getTicketsByMovieId(String movieId) {
        List<Ticket> tickets = ticketRepository.getTicketsByMovieId(movieId);
        return tickets.stream()
                .map(t -> modelMapper.map(t, TicketDTO.class))
                .collect(Collectors.toList());
    }

    public void addTicket(TicketDTO ticketDTO) {
        Ticket ticket = modelMapper.map(ticketDTO, Ticket.class);
        if (ticket.getTicketId() == null || ticket.getTicketId().isEmpty()) {
            ticket.setTicketId("T" + System.currentTimeMillis());
        }
        ticketRepository.addTicket(ticket);
    }
}
