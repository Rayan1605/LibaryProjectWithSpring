package com.project1.libaryproject.Controller;

import com.project1.libaryproject.Entity.Message;
import com.project1.libaryproject.Service.MessagesService;
import com.project1.libaryproject.Utils.ExtractJwt;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")//This is to allow the React app
@RestController
@RequestMapping("/api/messages")
@AllArgsConstructor
public class MessageController {

    private MessagesService messagesService;

    private String CheckJwt(String token) throws Exception{
        String userEmail = ExtractJwt.extractJwtExtraction(token, "\"sub\"");
        if (userEmail == null) {throw new Exception("You are not logged in");}
        return userEmail;
    }

    @PostMapping("/secure/add/message")
    public void postMessage(@RequestHeader(value = "Authorization") String token, @RequestBody Message messageRequest) throws Exception {
        messagesService.addMessage(CheckJwt(token), message);
    }

}
