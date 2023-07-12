package com.project1.libaryproject.Service;

import com.project1.libaryproject.DAO.BookRepository;
import com.project1.libaryproject.DAO.CheckOutRepository;
import com.project1.libaryproject.Entity.Book;
import com.project1.libaryproject.Entity.Checkout;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

        //First we need to find a specfic book by its id
        //When you call the database you need to return an optional

        Optional<Book> book = bookRepository.findById(bookId);
//If the book is not found we will throw an exception

        Checkout validateUser = checkout.findByUserEmailAndBookId(userEmail, bookId);
//Making sure validateUser is null because if not null then the user has already checked out the book
        if (validateUser != null) throw new Exception("You have already checked out this book");

        if (book.isEmpty()) throw new Exception("Book not found");

        if (book.get().getAvailable_copies() == 0) throw new Exception("Book is not available");

        book.get().setAvailable_copies(book.get().getAvailable_copies() - 1);
    bookRepository.save(book.get());
    }
}






















