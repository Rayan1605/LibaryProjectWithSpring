package com.project1.libaryproject.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")//This is to allow the React app
@RestController
@RequestMapping("/api/messages")
public class MessageController {
}
