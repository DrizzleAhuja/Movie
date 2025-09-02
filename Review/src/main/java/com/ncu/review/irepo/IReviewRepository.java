package com.ncu.review.irepo;

import com.ncu.review.model.Review;
import java.util.List;

public interface IReviewRepository {
    List<Review> getAllReviews();
    Review getReviewById(String reviewId);
    List<Review> getReviewsByMovieId(String movieId);
    Review addReview(Review review);
}
