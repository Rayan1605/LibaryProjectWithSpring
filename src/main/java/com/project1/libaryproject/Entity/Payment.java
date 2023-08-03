package com.project1.libaryproject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "payment")
public class Payment {
   @Id
   @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

   private String useremail;

   private double amount;
}
