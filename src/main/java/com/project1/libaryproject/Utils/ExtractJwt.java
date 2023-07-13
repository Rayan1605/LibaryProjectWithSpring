package com.project1.libaryproject.Utils;

import java.util.Base64;

public class ExtractJwt {
//This is because the token starts with Bearer and then the token so we need to take it off
    public static String extractJwtToken(String header) {
         header.replace("Bearer", "").trim();
    String[] parts = header.split("\\.");//This is to split the token into 3 parts
        // the first part is the header, the second part is the payload, and the third part is the signature
        // the // is to escape the "."
        // because it's a special character

        Base64.Decoder decoder = Base64.getUrlDecoder(); //This is to decode the token
        String payload = new String(decoder.decode(parts[1]));
        //Above is written so we can get just the payload part of the token
        // And ignore the header and the signature

   String[] entries = payload.split(",");
   //So every element in the payload will be it own element in the array



    }



}
