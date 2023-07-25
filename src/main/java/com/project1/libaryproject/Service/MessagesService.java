package com.project1.libaryproject.Service;

import com.project1.libaryproject.Entity.Message;
import com.project1.libaryproject.Repository.MessageRepository;
import com.project1.libaryproject.RequestModels.AdminQuestionRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class MessagesService {
    MessageRepository messageRepository;

    public void postMessage( String userEmail,Message message) {
    message.setUserEmail(userEmail);
    messageRepository.save(message);
    }

    public void putMessage(AdminQuestionRequest adminQuestionRequest,String userEmail) {
        //Below is searching for a message that contain this id
        Optional<Message>  message = messageRepository.findById(adminQuestionRequest.getId());

        if (message.isEmpty()) throw new IllegalStateException("Message not found");

        message.get().setAdminEmail(userEmail);
        message.get().setResponse(adminQuestionRequest.getQuestion());


    }

}
