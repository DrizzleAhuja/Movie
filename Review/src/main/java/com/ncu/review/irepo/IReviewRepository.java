package com.ncu.review.irepo;

import com.ncu.review.model.Review;
import java.util.List;

public interface IReviewRepository {
    List<Review> getAllReviews();
    Review getReviewById(String reviewId);
    Review addReview(Review review);
}
