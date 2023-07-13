package com.project1.libaryproject.Controller;

import com.project1.libaryproject.Entity.Book;
import com.project1.libaryproject.Service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")//This is to allow the react app
// to access the api
@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController {
    @Autowired
    private BookService bookService;

    @PutMapping("/secure/checkout") // the secure mean only a user with a
    // role of user can access this
public Book checkoutBook(@RequestParam Long bookId) throws Exception{

        String userEmail = "testuser@email.com";
        return bookService.checkoutBook(userEmail, bookId);
    }

}
