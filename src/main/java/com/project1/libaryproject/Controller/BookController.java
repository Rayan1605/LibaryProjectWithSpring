package com.project1.libaryproject.Controller;

import com.project1.libaryproject.Entity.Book;
import com.project1.libaryproject.Service.BookService;
import com.project1.libaryproject.Utils.ExtractJwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public int currentLoansCount(@RequestHeader(value = "Authorization") String token) {
        //We are extracting the token from the header and passing it to the method
        //we are expecting something in the request header that has a key of Authorization
        // it's validating with okta automatically, and then we are passing the token to the method
        String userEmail = "testuser@email.com";
        return bookService.currentLoansCount(userEmail);
    }

    @PutMapping("/secure/checkout") // the secure mean only a user with a
    // role of user can access this
    //Put is referring to updating the book
    public Book checkoutBook(@RequestParam Long bookId,
                             @RequestHeader(value = "Authorization") String token)
            throws Exception {

        String userEmail = ExtractJwt.extractJwtExtraction(token, "sub");
        //Above is To get the user's email
        return bookService.checkoutBook(userEmail, bookId);
    }

    @GetMapping("/secure/ischeckoutedout/byuser")
    public boolean checkoutBookByUser(@RequestParam Long bookId,@RequestHeader(value = "Authorization") String token) {
//Remember this is to check if the user has already checked out the book
        String userEmail = ExtractJwt.extractJwtExtraction(token, "sub");
        //Above is To get the user's email
        return bookService.checkoutBookByUser(userEmail, bookId);

    }
}
