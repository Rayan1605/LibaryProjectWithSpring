package com.project1.libaryproject.Controller;

import com.project1.libaryproject.Entity.Book;
import com.project1.libaryproject.ResponseModel.CurrentLoans;
import com.project1.libaryproject.Service.BookService;
import com.project1.libaryproject.Utils.ExtractJwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")//This is to allow the React app
// to access the api
@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/secure/currentloans/count") // the secure mean only a user with a
    // role of user can access this
    ////The secure we set up in the okta in the utils folder
    public int currentLoansCount(@RequestHeader(value = "Authorization") String token) {
        //We are extracting the token from the header and passing it to the method
        //we are expecting something in the request header that has a key of Authorization
        // it's validating with okta automatically, and then we are passing the token to the method
        String userEmail = ExtractJwt.extractJwtExtraction(token, "sub");
        //Above is To get the user's email
        return bookService.currentLoansCount(userEmail);
    }

    @PutMapping("/secure/checkout") // the secure mean only a user with a
    // role of user can access this
    //Put is referring to updating the book
    //The secure we set up in the okta in the utils folder
    public Book checkoutBook(@RequestParam Long bookId,
                             @RequestHeader(value = "Authorization") String token) throws Exception {

        String userEmail = ExtractJwt.extractJwtExtraction(token, "sub");
        //Above is To get the user's email
        return bookService.checkoutBook(userEmail, bookId);
    }

    @GetMapping("/secure/ischeckoutedout/byuser")
    public boolean checkoutBookByUser(@RequestParam Long bookId,
                                      @RequestHeader(value = "Authorization") String token) {
        ////The secure we set up in the okta in the utils folder
//Remember this is to check if the user has already checked out the book
        String userEmail = ExtractJwt.extractJwtExtraction(token, "sub");
        //Above is To get the user's email
        return bookService.checkoutBookByUser(userEmail, bookId);

    }

    @GetMapping("/secure/currentloans")
    public List<CurrentLoans> currentLoans(@RequestHeader(value = "Authorization") String token) throws Exception {
        String userEmail = CheckJwt(token);
        return bookService.getCurrentLoans(userEmail);

    }

    private String CheckJwt(String token) throws Exception {
        String userEmail = ExtractJwt.extractJwtExtraction(token, "\"sub\"");
        if (userEmail == null) {
            throw new Exception("You are not logged in");
        }
        return userEmail;
    }
    @PutMapping("/secure/return")
    public void returnbook(@RequestHeader(value = "Authorization") String token,
                           @RequestParam Long bookId) throws Exception {

        String userEmail = CheckJwt(token); //extracting from Jwt
        bookService.returnBook(userEmail, bookId);//then returning the book
    }
    @PutMapping("/secure/renew/loan")
    public void renewLoan(@RequestHeader(value = "Authorization") String token,
                           @RequestParam Long bookId) throws Exception {
        //request param is to get the book id from the url
        String userEmail = CheckJwt(token); //extracting from Jwt
        bookService.renewBook(userEmail, bookId);//then returning the book
    }


}

