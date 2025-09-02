package com.ncu.review.repository;

import com.ncu.review.model.Review;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewRowMapper implements RowMapper<Review> {
    @Override
    public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
        Review review = new Review();
        review.setReviewId(rs.getString("review_id"));
        review.setMovieId(rs.getString("movie_id")); // Added movieId mapping
        review.setReviewText(rs.getString("review_text"));
        review.setRating(rs.getInt("rating"));
        return review;
    }
}
