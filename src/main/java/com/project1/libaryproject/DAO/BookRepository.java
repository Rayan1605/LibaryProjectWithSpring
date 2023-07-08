package com.project1.libaryproject.DAO;

import com.project1.libaryproject.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
