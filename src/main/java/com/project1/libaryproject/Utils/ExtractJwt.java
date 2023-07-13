package com.project1.libaryproject.Utils;

public class ExtractJwt {
//This is because the token starts with Bearer and then the token so we need to take it off
    public static String extractJwtToken(String header) {
         header.replace("Bearer", "").trim();
    String[] parts = header.split("\\.");


    }



}
