package com.project1.libaryproject.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "payment")
public class Payment {
   @Id
   @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
   @Column(name = "id")
    private Long id;
    @Column(name = "user_email")
       private String userEmail;
    @Column(name = "amount")
       private double amount;
}
