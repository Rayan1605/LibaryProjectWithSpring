package com.project1.libaryproject.Repository;

import com.project1.libaryproject.Entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CheckOutRepository extends JpaRepository<Checkout, Long> {

    Checkout findByUserEmailAndBookId(String UserEmail, Long BookId);

    List<Checkout> findByUserEmail(String UserEmail);

    void deleteAllByBookId(@Param("book_id") Long bookId);
}
