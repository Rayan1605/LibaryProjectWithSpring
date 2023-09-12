package Backend.libaryproject.Service;

import Backend.libaryproject.RequestModels.AdminQuestionRequest;
import Backend.libaryproject.Entity.Message;
import Backend.libaryproject.Repository.MessageRepository;
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

    public void putMessage(AdminQuestionRequest adminQuestionRequest, String userEmail) {
        //Below is searching for a message that contain this id
        Optional<Message>  message = messageRepository.findById(adminQuestionRequest.getId());

        if (message.isEmpty()) throw new IllegalStateException("Message not found");

        message.get().setAdminEmail(userEmail);
        message.get().setResponse(adminQuestionRequest.getQuestion());
        message.get().setClosed(true);
        messageRepository.save(message.get());

    }

}
