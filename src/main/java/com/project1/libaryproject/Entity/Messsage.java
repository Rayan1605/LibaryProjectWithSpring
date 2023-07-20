package com.project1.libaryproject.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "messages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Messsage {
@Id
@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
@Column(name = "id")
private Long id;
@Column(name = "user_email")
private String userEmail;
@Column(name = "title")


}
