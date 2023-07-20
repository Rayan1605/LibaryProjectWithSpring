package com.project1.libaryproject.Service;

import com.project1.libaryproject.DAO.BookRepository;
import com.project1.libaryproject.DAO.CheckOutRepository;
import com.project1.libaryproject.Entity.Book;
import com.project1.libaryproject.Entity.Checkout;
import com.project1.libaryproject.ResponseModel.CurrentLoans;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
@AllArgsConstructor
public class BookService {

    private BookRepository bookRepository;
    //Using lombok to generate constructor for dependency injection
    private CheckOutRepository checkout;
    private final CheckOutRepository checkOutRepository;

    public Book checkoutBook(String userEmail, Long bookId) throws Exception {
//This method will checkout a book by a user
//It will check if the user has already checked out the book
//If the user has already checked out the book it will throw an exception
//If the user has not checked out the book it will checkout the book and return the book

        //First we need to find a specific book by its id
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
    public boolean checkoutBookByUser(String userEmail, Long bookId) {
        Checkout validateCheckout = checkOutRepository.findByUserEmailAndBookId(userEmail, bookId);
        return validateCheckout != null;
    }

    public int currentLoansCount(String userEmail) {
        return checkOutRepository.findByUserEmail(userEmail).size();
    }

    public List<CurrentLoans> getCurrentLoans(String userEmail) throws Exception {
        List<Checkout> checkoutList = checkOutRepository.findByUserEmail(userEmail);
        List<CurrentLoans> currentLoans = new ArrayList<>();
        List<Book> books = getBooks(checkoutList);
        //Going to check if the book is overdue and how long it is
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        for(Book book: books){
            // Each book in our checkoutList we are going to look for the book in our book list,
            // and once we find it, then we can end the loop and check to see if the book is overdue
            Optional<Checkout> checkout = checkoutList.stream().
                    filter(x-> x.getBookId().equals(book.getId())).findFirst();


               if(checkout.isPresent()){
                   Date return_Date = formatter.parse(checkout.get().getReturn_date());
                     Date today = formatter.parse(LocalDate.now().toString());
                   TimeUnit timeUnit = TimeUnit.DAYS;
                     long diff = timeUnit.convert(return_Date.getTime() - today.getTime(),
                             TimeUnit.MILLISECONDS);
                       currentLoans.add(new CurrentLoans(book, (int)diff));

               }
        }
        return currentLoans;
    }

    public List<Book> getBooks(List<Checkout> checkoutList) {
        //So here we are going to get all the books that the user has checked out,
        //However, we can only get the book ids



        List<Long> bookIds = new ArrayList<>();
// We are going to get all the book ids that the user has checked out
        for (Checkout checkout : checkoutList) {
            bookIds.add(checkout.getBookId());
        }
        return bookRepository.findBooksByBookIds(bookIds);

    }

    public void returnBook (String userEmail, Long BookId) throws Exception {

    }

}























