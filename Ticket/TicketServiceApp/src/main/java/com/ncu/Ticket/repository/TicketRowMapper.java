package com.ncu.Ticket.repository;

import com.ncu.Ticket.model.Ticket;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketRowMapper implements RowMapper<Ticket> {
    @Override
    public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ticket ticket = new Ticket();
        ticket.setTicketId(rs.getString("ticket_id"));
        ticket.setMovieId(rs.getString("movie_id"));
        ticket.setUserId(rs.getString("user_id"));
        ticket.setSeatNumber(rs.getInt("seat_number"));
        return ticket;
    }
}
