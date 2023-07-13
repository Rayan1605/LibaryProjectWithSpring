package com.project1.libaryproject.Service;

import com.project1.libaryproject.DAO.BookRepository;
import com.project1.libaryproject.DAO.CheckOutRepository;
import com.project1.libaryproject.Entity.Book;
import com.project1.libaryproject.Entity.Checkout;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class BookService {

    private BookRepository bookRepository;
    //Using lomback to generate constructor for dependency injection
    private CheckOutRepository checkout;
    private final CheckOutRepository checkOutRepository;

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
        int validate = Validate(validateUser, book);
        switch (validate) {
            case 1 -> throw new Exception("You have already checked out this book");
            case 2 -> throw new Exception("Book not found");
            case 3 -> throw new Exception("Book is not available");
        }
        book.get().setAvailable_copies(book.get().getAvailable_copies() - 1);
        bookRepository.save(book.get());
//If the book is found we will checkout the book
        Checkout checkout = new Checkout(
                userEmail,
                LocalDate.now().toString(),
                LocalDate.now().plusDays(7).toString(),
                book.get().getId()

        );
        checkOutRepository.save(checkout);
        return book.get();

    }

    private int Validate(Checkout validateUser, Optional<Book> book) {
        if (validateUser != null) return 1;
        if (book.isEmpty()) return 2;
        if (book.get().getAvailable_copies() == 0) return 3;
        return 0;
    }

    //This is to check if the user has already checked out the book if it did then we will return true
    // and print the already checked out in our React app
    public Boolean checkoutBookByUser(String userEmail, Long bookId) {
        Checkout validateCheckout = checkOutRepository.findByUserEmailAndBookId(userEmail, bookId);
        return validateCheckout != null;
    }

    public int currentLoansCount(String userEmail) {
        return checkOutRepository.findByUserEmail(userEmail).size();
    }
}























