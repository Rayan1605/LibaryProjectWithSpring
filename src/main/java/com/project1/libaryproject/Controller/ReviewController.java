package com.project1.libaryproject.Controller;

import com.project1.libaryproject.RequestModels.ReviewRequest;
import com.project1.libaryproject.Utils.ExtractJwt;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")//This is to allow the React app
// to access the api
@RestController //This is to tell spring that this is a controller
@RequestMapping("/api/reviews") //This is to tell spring that this is the path
@AllArgsConstructor
public class ReviewController {

    private ReviewController reviewController;

    @GetMapping("/secure/user/book")
    //CheckingIfUserHasAlreadyReviewedTheBook
    public boolean CheckingUserReviewedBook(@RequestHeader(value = "Authorization")
                                                String token,
                                            @RequestParam Long bookId) throws Exception {


    }
    @PostMapping("/secure")
    public void postReview(@RequestHeader(value = "Authorization") String token,
                           @RequestBody ReviewRequest reviewRequest) throws Exception {
     String userEmail = ExtractJwt.extractJwtExtraction(token, "\"sub\"");
     if (userEmail == null) {throw new Exception("You are not logged in");}

        reviewController.postReview(userEmail, reviewRequest);

    }
}
