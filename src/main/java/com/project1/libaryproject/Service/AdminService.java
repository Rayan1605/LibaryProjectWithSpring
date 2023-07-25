package com.project1.libaryproject.Service;

import com.project1.libaryproject.Repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class AdminService {

    private BookRepository bookRepository;

public void postBook()


}
