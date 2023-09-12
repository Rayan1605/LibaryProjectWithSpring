package Backend.libaryproject.Controller;

import Backend.libaryproject.RequestModels.AdminQuestionRequest;
import Backend.libaryproject.Utils.ExtractJwt;
import Backend.libaryproject.Entity.Message;
import Backend.libaryproject.Service.MessagesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://localhost:3000")//This is to allow the React app
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
    public void postMessage(@RequestHeader(value = "Authorization") String token,
                            @RequestBody Message messageRequest) throws Exception {

        String userEmail = CheckJwt(token);
        messagesService.postMessage(userEmail, messageRequest);

    }
    @PutMapping("/secure/admin/message")
    public void putMessage(@RequestHeader(value = "Authorization") String token,
                           @RequestBody AdminQuestionRequest adminQuestionRequest) throws Exception {

        String userEmail = CheckJwt(token);
        if (!CheckIfAdmin(token))throw new Exception("You are not an admin");
        messagesService.putMessage(adminQuestionRequest, userEmail);

    }

    private boolean CheckIfAdmin(String token) {
        String admin = ExtractJwt.extractJwtExtraction(token, "\"userType\"");
        return admin != null && admin.equals("admin");
    }

}
