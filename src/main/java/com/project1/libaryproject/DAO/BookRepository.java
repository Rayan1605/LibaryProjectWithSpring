package com.project1.libaryproject.DAO;

import com.project1.libaryproject.Entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    //Since Jpa has no Search option we will create a method to search for books by title
    //Which will generate the method at runtime

    Page<Book> findByTitleContaining(@Param("title") String title, Pageable pageable);
    //This method will search for books by title and return a page of books

    Page<Book> findByCategory(@Param("category") String category, Pageable pageable);

    //This method will search for books by category and return a page of books

    @Query("select o from Book o where id in :book_ids")
    List<Book> findBooksByBookIds(@Param("book_ids") List<Long> bookIds);
}
