package com.project1.libaryproject.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "checkout")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Checkout {
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
