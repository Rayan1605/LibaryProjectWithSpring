package com.project1.libaryproject.Controller;

import com.project1.libaryproject.Entity.Book;
import com.project1.libaryproject.Service.BookService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")//This is to allow the react app
// to access the api
@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController {
    private BookService bookService;

    @PutMapping("/secure/checkout") // the secure mean only a user with a
    // role of user can access this
    //Put is referring to updating the book
    public Book checkoutBook(@RequestParam Long bookId) throws Exception {

        String userEmail = "testuser@email.com";
        return bookService.checkoutBook(userEmail, bookId);
    }

    @GetMapping("/secure/ischeckoutedout/byuser")
    public boolean checkoutBookByUser(@RequestParam Long bookId) {
//Remember this is to check if the user has already checked out the book
        String userEmail = "testuser@email.com";
        return bookService.checkoutBookByUser(userEmail, bookId);

    }
}
