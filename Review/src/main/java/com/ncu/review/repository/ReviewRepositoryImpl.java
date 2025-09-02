package com.ncu.review.repository;

import com.ncu.review.model.Review;
import com.ncu.review.irepo.IReviewRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Repository
public class ReviewRepositoryImpl implements IReviewRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Review> getAllReviews() {
        String sql = "SELECT * FROM review";
        return jdbcTemplate.query(sql, new ReviewRowMapper());
    }

    @Override
    public Review getReviewById(String reviewId) {
        String sql = "SELECT * FROM review WHERE review_id = ?";
        return jdbcTemplate.queryForObject(sql, new ReviewRowMapper(), reviewId);
    }

    @Override
    public List<Review> getReviewsByMovieId(String movieId) {
        String sql = "SELECT * FROM review WHERE movie_id = ?";
        return jdbcTemplate.query(sql, new ReviewRowMapper(), movieId);
    }

    @Override
    public Review addReview(Review review) {
        String sql = "INSERT INTO review (review_id, movie_id, review_text, rating) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, review.getReviewId(), review.getMovieId(), review.getReviewText(), review.getRating());
        return review;
    }
}
