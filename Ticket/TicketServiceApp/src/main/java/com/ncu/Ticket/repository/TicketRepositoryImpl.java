package com.ncu.Ticket.repository;

import com.ncu.Ticket.irepo.ITicketRepository;
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
    public List<Ticket> getAllTickets() {
        String sql = "SELECT * FROM ticket";
        return jdbcTemplate.query(sql, new TicketRowMapper());
    }

    @Override
    public List<Ticket> getTicketsByMovieId(String movieId) {
        String sql = "SELECT * FROM ticket WHERE movie_id = ?";
        return jdbcTemplate.query(sql, new TicketRowMapper(), movieId);
    }

    @Override
    public void addTicket(Ticket ticket) {
        String sql = "INSERT INTO ticket (ticket_id, movie_id, user_id, seat_number) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
            ticket.getTicketId(),
            ticket.getMovieId(),
            ticket.getUserId(),
            ticket.getSeatNumber()
        );
    }
}
