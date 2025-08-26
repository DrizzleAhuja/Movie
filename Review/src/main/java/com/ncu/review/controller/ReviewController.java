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

    @GetMapping("/review/{reviewId}")
    public String getReviewById(@PathVariable("reviewId") String reviewId) {
        return "Fetching review with ID: " + reviewId;
    }

    @GetMapping("/review/search/{reviewName}")
    public String getReviewByName(@PathVariable("reviewName") String reviewName) {
        return "Searching for review with name: " + reviewName;
    }
}