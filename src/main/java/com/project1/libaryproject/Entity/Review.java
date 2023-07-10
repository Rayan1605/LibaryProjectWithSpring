package com.project1.libaryproject.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "review")
@Data

public class Review {
    @Id
    @GeneratedValue()
    @Column(name = "id")
    private long id;

    @Column(name = "user_email")
    private String user_email;

    @Column(name = "date")
 @CreationTimestamp
    private Date date;

@Column(name = "rating")
    private double rating;
@Column(name = "book_id")
private Long book_id;

    @Column(name = "review_description")
private String reviewDecription;








}
