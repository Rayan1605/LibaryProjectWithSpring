package com.project1.libaryproject.Controller;

import com.project1.libaryproject.RequestModels.AddBookRequest;
import com.project1.libaryproject.Utils.ExtractJwt;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")//This is to allow the React app
@AllArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {

    private AdminController adminController;

    @PostMapping("/secure/add/book")
    public void postBook(@RequestHeader (value = "Authorization")String token ,
                         @RequestBody AddBookRequest addBookRequest) throws Exception {

        adminController.postBook();

    }
    private boolean CheckIfAdmin(String token) {
        String admin = ExtractJwt.extractJwtExtraction(token, "\"userType\"");
        return admin != null && admin.equals("admin");
    }
}
