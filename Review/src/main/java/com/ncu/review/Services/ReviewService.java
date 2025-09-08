package com.ncu.review.Services;

import com.ncu.review.model.Review;
import com.ncu.review.dto.ReviewDTO;
import com.ncu.review.irepo.IReviewRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    @Autowired
    private IReviewRepository reviewRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<ReviewDTO> getAllReviews() {
        List<Review> reviews = reviewRepository.getAllReviews();
        return reviews.stream()
            .map(r -> modelMapper.map(r, ReviewDTO.class))
            .collect(Collectors.toList());
    }

    public ReviewDTO getReviewById(String reviewId) {
        Review review = reviewRepository.getReviewById(reviewId);
        if (review == null) {
            return null; // Or throw an exception if review is not found
        }
        return modelMapper.map(review, ReviewDTO.class);
    }

    public List<ReviewDTO> getReviewsByMovieId(String movieId) {
        List<Review> reviews = reviewRepository.getReviewsByMovieId(movieId);
        return reviews.stream()
                .map(r -> modelMapper.map(r, ReviewDTO.class))
                .collect(Collectors.toList());
    }

    public List<ReviewDTO> getReviewsByName(String reviewName) {
        List<Review> reviews = reviewRepository.getAllReviews().stream()
                .filter(review -> review.getReviewText().toLowerCase().contains(reviewName.toLowerCase()))
                .collect(Collectors.toList());
        return reviews.stream()
                .map(r -> modelMapper.map(r, ReviewDTO.class))
                .collect(Collectors.toList());
    }

    public ReviewDTO addReview(ReviewDTO reviewDTO) {
        Review review = modelMapper.map(reviewDTO, Review.class);
        // Simple ID generation: "R" + System.currentTimeMillis()
        if (review.getReviewId() == null || review.getReviewId().isEmpty()) {
        review.setReviewId("R" + System.currentTimeMillis());
        }
        reviewRepository.addReview(review);
        return modelMapper.map(review, ReviewDTO.class);
    }
}
