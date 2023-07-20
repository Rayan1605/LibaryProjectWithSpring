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
public class Message {
@Id
@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
@Column(name = "id")
private Long id;

@Column(name = "user_email")
private String userEmail;

@Column(name = "title")
private String title;

@Column(name = "question")
private String question;

@Column(name = "admin_email")
private String adminEmail;

@Column(name = "response")
private String response;

@Column(name = "closed")
private boolean closed;

}