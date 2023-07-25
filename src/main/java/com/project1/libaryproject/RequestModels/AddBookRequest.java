package com.project1.libaryproject.RequestModels;

import lombok.Data;
//This is the Object that we are going to receive from the front end
@Data
public class AddBookRequest {

private String title;

private String author;

private String description;

private String copies;

private String img;

private String category;

}
