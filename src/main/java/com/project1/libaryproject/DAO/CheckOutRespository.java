package com.project1.libaryproject.DAO;

import com.project1.libaryproject.Entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckOutRespository extends JpaRepository<Checkout, Long> {

}
