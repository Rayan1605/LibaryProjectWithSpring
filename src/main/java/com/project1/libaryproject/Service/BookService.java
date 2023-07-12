package com.project1.libaryproject.Service;

import com.project1.libaryproject.DAO.BookRepository;
import com.project1.libaryproject.DAO.CheckOutRepository;
import com.project1.libaryproject.Entity.Book;
import com.project1.libaryproject.Entity.Checkout;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class BookService {

private BookRepository bookRepository;
//Using lomback to generate constructor for dependency injection
private CheckOutRepository checkout;

public Book checkoutBook(String userEmail, Long bookId) throws Exception {
//This method will checkout a book by a user
//It will check if the user has already checked out the book
//If the user has already checked out the book it will throw an exception
//If the user has not checked out the book it will checkout the book and return the book


}

}





















