package com.project1.libaryproject.Service;

import com.project1.libaryproject.Entity.Book;
import com.project1.libaryproject.Repository.BookRepository;
import com.project1.libaryproject.RequestModels.AddBookRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class AdminService {

    private BookRepository bookRepository;

public void postBook(AddBookRequest addBookRequest) {
    Book book = new Book();
}


}
