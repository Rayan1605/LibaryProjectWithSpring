package com.project1.libaryproject.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "checkout")
@Data
@NoArgsConstructor
public class Checkout {

    public Checkout(String UserEmail, String checkout_date, String return_date, Long BookId) {
        this.UserEmail = UserEmail;
        this.checkout_date = checkout_date;
        this.return_date = return_date;
        this.BookId = BookId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "user_email")
    private String UserEmail;

    @Column(name = "checkout_date")
    private String checkout_date;

    @Column(name = "return_date")
    private String return_date;

    @Column(name = "book_id")
    private Long BookId;

}
