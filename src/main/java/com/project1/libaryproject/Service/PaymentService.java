package com.project1.libaryproject.Service;

import com.project1.libaryproject.Repository.PaymentRepository;
import com.stripe.Stripe;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PaymentService {
    private PaymentRepository paymentRepository;

    //This automatically injects any dependencies needed into the constructor.
@Autowired
    public PaymentService(PaymentRepository paymentRepository,
                          // Getting the secret key from the application.properties file
                          @Value("${stripe.key.secret}") String secretKey) {
        this.paymentRepository = paymentRepository;
        Stripe.apiKey = secretKey;
    }

}