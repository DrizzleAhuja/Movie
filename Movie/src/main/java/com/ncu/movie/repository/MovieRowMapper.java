package com.ncu.movie.repository;

import com.ncu.movie.model.Movie;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
        Movie movie = new Movie();
        movie.setMovieId(rs.getString("movie_id"));
        movie.setMovieName(rs.getString("movie_name"));
        movie.setRating(rs.getInt("rating"));
        return movie;
    }
}