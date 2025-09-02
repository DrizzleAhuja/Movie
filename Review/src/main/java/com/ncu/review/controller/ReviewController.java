package com.ncu.review.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.ncu.review.dto.ReviewDTO;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private com.ncu.review.Services.ReviewService reviewService;

    @GetMapping
    public List<ReviewDTO> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @PostMapping
    public String addReview(@RequestBody ReviewDTO reviewDTO) {
        reviewService.addReview(reviewDTO);
        return "Review added to DB!";
    }

    @GetMapping("/movie/{movieId}")
    public List<ReviewDTO> getReviewsByMovieId(@PathVariable("movieId") String movieId) {
        return reviewService.getReviewsByMovieId(movieId);
    }

    @GetMapping("/review/{reviewId}")
    public ReviewDTO getReviewById(@PathVariable("reviewId") String reviewId) {
        return reviewService.getReviewById(reviewId);
    }

    @GetMapping("/review/search/{reviewName}")
    public List<ReviewDTO> getReviewsByName(@PathVariable("reviewName") String reviewName) {
        // You'll need to implement getReviewsByName in ReviewService
        // For now, this is a placeholder.
        return reviewService.getAllReviews().stream()
                .filter(review -> review.getReviewText().toLowerCase().contains(reviewName.toLowerCase()))
                .collect(Collectors.toList());
    }
}