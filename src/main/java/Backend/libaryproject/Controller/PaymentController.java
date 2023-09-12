package Backend.libaryproject.Controller;

import Backend.libaryproject.RequestModels.PaymentInfoRequest;
import Backend.libaryproject.Service.PaymentService;
import Backend.libaryproject.Utils.ExtractJwt;
import com.stripe.model.PaymentIntent;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
@RequestMapping("/api/payment/secure")
public class PaymentController {

    private PaymentService paymentService;
//This code is creating a PaymentIntent,
// converting it to JSON, and returning it in an API response.
    @PostMapping("/payment-intent")
    public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfoRequest paymentInfoRequest) throws Exception {
        PaymentIntent paymentIntent= paymentService.createPaymentIntent(paymentInfoRequest);
        //toJson() converts the PaymentIntent object to a JSON string representation
        //Saves JSON string in paymentJson variable
        String Payment = paymentIntent.toJson();
        return new ResponseEntity<>(Payment, HttpStatus.OK);
    }

    @PutMapping("/payment-Complete")
    public ResponseEntity<String> stripePaymentComplete(@RequestHeader(value = "Authorization")
                                                        String token) throws Exception {

        String userEmail = ExtractJwt.extractJwtExtraction(token,"\"sub\"");
        if (userEmail == null) {
            return new ResponseEntity<>("User not found", HttpStatus.BAD_REQUEST);
        }
        return paymentService.stripePayment(userEmail);
    }
}
