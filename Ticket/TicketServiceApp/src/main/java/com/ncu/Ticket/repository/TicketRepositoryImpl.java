package com.ncu.Ticket.repository;

import com.ncu.Ticket.irepo.ITicketRepository;
import com.ncu.Ticket.dto.TicketDTO;
import com.ncu.Ticket.model.Ticket;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TicketRepositoryImpl implements ITicketRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TicketDTO> getAllTickets() {
        String sql = "SELECT * FROM ticket";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new TicketDTO(
            rs.getString("ticket_id"),
            rs.getString("ticket_name")
        ));
    }

    @Override
    public void addTicket(TicketDTO ticketDTO) {
        String sql = "INSERT INTO ticket (ticket_id, ticket_name) VALUES (?, ?)";
        jdbcTemplate.update(sql,
            ticketDTO.getTicketId(),
            ticketDTO.getTicketName()
        );
    }
}
