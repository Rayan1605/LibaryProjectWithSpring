package com.project1.libaryproject.Service;

import com.project1.libaryproject.DAO.BookRepository;
import com.project1.libaryproject.DAO.CheckOutRepository;
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


}





















