package com.project1.libaryproject.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")//This is to allow the React app
// to access the api
@RestController //This is to tell spring that this is a controller
@RequestMapping("/api/reviews") //This is to tell spring that this is the path
public class ReviewController {

    private R
}
