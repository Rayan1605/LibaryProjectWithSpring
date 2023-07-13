package com.project1.libaryproject.Utils;

public class ExtractJwt {
//This is because the token starts with Bearer and then the token so we need to take it off
    public static String extractJwtToken(String header) {
         header.replace("Bearer", "").trim();
    String[] parts = header.split("\\.");//This is to split the token into 3 parts
        // the first part is the header, the second part is the payload, and the third part is the signature
        // the // is to escape the "."
        // because it's a special character



    }



}
