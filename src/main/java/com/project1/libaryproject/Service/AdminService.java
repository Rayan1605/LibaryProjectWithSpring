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
    book.setTitle(addBookRequest.getTitle());
    book.setAuthor(addBookRequest.getAuthor());
    book.setDescription(addBookRequest.getDescription());
    book.setAvailable_copies(addBookRequest.getCopies());
    book.setCopies(addBookRequest.getCopies());
    book.setImage(addBookRequest.getImg());
    book.setCategory(addBookRequest.getCategory());
    bookRepository.save(book);

}


}