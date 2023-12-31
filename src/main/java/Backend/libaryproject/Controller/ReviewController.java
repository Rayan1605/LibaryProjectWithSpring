package Backend.libaryproject.Controller;

import Backend.libaryproject.RequestModels.ReviewRequest;
import Backend.libaryproject.Utils.ExtractJwt;
import Backend.libaryproject.Service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://localhost:3000")//This is to allow the React app
// to access the api
@RestController //This is to tell spring that this is a controller
@RequestMapping("/api/reviews") //This is to tell spring that this is the path
@AllArgsConstructor
public class ReviewController {

   private ReviewService ReviewService;

    @GetMapping("/secure/user/book")
    //CheckingIfUserHasAlreadyReviewedTheBook
    public boolean CheckingUserReviewedBook(@RequestHeader(value = "Authorization")
                                                String token,
                                            @RequestParam Long bookId) throws Exception {
        return ReviewService.checkIfUserHasAlreadyLeftAReview(CheckJwt(token), bookId);

}

    @PostMapping("/secure")
    public void postReview(@RequestHeader(value = "Authorization") String token,
                           @RequestBody ReviewRequest reviewRequest) throws Exception {

        ReviewService.postReview(CheckJwt(token), reviewRequest);

    }

    private String CheckJwt(String token) throws Exception{
        String userEmail = ExtractJwt.extractJwtExtraction(token, "\"sub\"");
        if (userEmail == null) {throw new Exception("You are not logged in");}
        return userEmail;
    }

}
