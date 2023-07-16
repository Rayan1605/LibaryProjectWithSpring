package com.project1.libaryproject.ResponseModel;

import com.project1.libaryproject.Entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CurrentLoans {

    private Book book;
    int daysLeft;

}
