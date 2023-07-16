package com.project1.libaryproject.RequestModels;

import lombok.Data;

import java.util.Optional;

@Data
public class ReviewRequest {
private Long bookId;
private double rating;
private Optional<String> reviewDescription;

}
