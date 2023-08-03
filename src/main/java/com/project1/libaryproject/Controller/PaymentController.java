package com.project1.libaryproject.Controller;

import com.project1.libaryproject.RequestModels.PaymentInfoRequest;
import com.project1.libaryproject.Service.PaymentService;
import lombok.AllArgsConstructor;
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
        return ResponseEntity.ok(paymentService.createPaymentIntent(paymentInfoRequest));
    }

}
