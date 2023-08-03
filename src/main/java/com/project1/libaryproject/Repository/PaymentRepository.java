package com.project1.libaryproject.Repository;

import com.project1.libaryproject.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment ,Long> {
    Payment findByUserEmail(String userEmail);
}
