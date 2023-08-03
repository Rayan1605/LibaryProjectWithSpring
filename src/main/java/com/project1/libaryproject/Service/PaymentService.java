package com.project1.libaryproject.Service;

import com.project1.libaryproject.Repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class PaymentService {
    private PaymentRepository paymentRepository;


}
