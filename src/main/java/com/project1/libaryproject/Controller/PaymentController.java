package com.project1.libaryproject.Controller;

import com.project1.libaryproject.RequestModels.PaymentInfoRequest;
import com.project1.libaryproject.Service.PaymentService;
import com.stripe.model.PaymentIntent;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
@RequestMapping("/api/payment/secure")
public class PaymentController {

    private PaymentService paymentService;

    @PostMapping("/payment-intent")
    public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfoRequest paymentInfoRequest) throws Exception {
        PaymentIntent paymentIntent= paymentService.createPaymentIntent(paymentInfoRequest);
        String Payment = paymentIntent.toJson();
        return new ResponseEntity<>(Payment, HttpStatus.OK);
    }

    @PutMapping("/payment-Complete")
    public ResponseEntity<String> stripePaymentComplete(@RequestHeader(value = "Authorization")
                                                        String token) throws Exception {

    }
}
