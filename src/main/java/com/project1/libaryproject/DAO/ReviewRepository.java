package com.project1.libaryproject.DAO;

import com.project1.libaryproject.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {


}
