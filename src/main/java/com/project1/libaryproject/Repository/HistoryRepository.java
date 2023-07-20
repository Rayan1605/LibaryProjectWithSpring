package com.project1.libaryproject.Repository;

import com.project1.libaryproject.Entity.Histroy;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<Histroy,Long> {

    Page<Histroy> findBooksByUserEmail(@Param("user_email") String userEmail, Pageable pageable);
}
