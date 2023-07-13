package com.project1.libaryproject.DAO;

import com.project1.libaryproject.Entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckOutRepository extends JpaRepository<Checkout, Long> {

    Checkout findByUserEmailAndBookId(String UserEmail, Long BookId);

    List<Checkout> findByUserEmail(String UserEmail);
}
