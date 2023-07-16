package com.project1.libaryproject.Service;

import com.project1.libaryproject.DAO.BookRepository;
import com.project1.libaryproject.DAO.ReviewRepository;
import com.project1.libaryproject.Entity.Review;
import com.project1.libaryproject.RequestModels.ReviewRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
@AllArgsConstructor
@Transactional //  commits the transaction after the method completes successfully.
// If an exception is thrown, the transaction will be rolled back.
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;

    public void postReview(String userEmail, ReviewRequest reviewRequest) throws Exception {
        Review Validate = reviewRepository.findByuserEmailAndBookId(userEmail, reviewRequest.getBookId());

        if (Validate != null) throw new Exception("You have already posted a review for this book");
        Review review = new Review();

        review.setBookId(reviewRequest.getBookId());
        review.setRating(reviewRequest.getRating());
        if (reviewRequest.getReviewDescription().isPresent()) { //because remember review description is
            // optional so we first need to check if it is present or null if it is present then we will set the
            // so since reviewRequest is actually  Optional<String>
            // we need to do it differently and use the map function
            // so we will use the map function to convert the Optional<String> to String
            review.setReviewDecription(reviewRequest.getReviewDescription().map(
                    Object::toString).orElse(null));

        }
        review.setDate(Date.valueOf(java.time.LocalDate.now())); //getting the current time
        review.setUser_email(userEmail);

    }
}
