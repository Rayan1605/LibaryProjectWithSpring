package com.project1.libaryproject.Utils;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class ExtractJwt {
    //This is because the token starts with Bearer and then the token so we need to take it off
    public static String extractJwtToken(String header,String extraction) {
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

        Map<String, String> map = new HashMap<>();// This is to store the key value pairs

        for (String entry : entries) {
            //We are looping through the entries array to find the value of sub
            // which consists of the user's email
            String[] keyValue = entry.split(":");
            if (keyValue[0].equals(extraction)) { // the slash is referring to the double quotes
                // because the key is in double quotes
                int remove = 1;
                //Then we had the key but for the value we need to remove the double quotes
                // or anything extra so the value is ONLY the email
                if (keyValue[1].endsWith("}")) {
                    remove = 2;
                }
                keyValue[1] = keyValue[1].substring(0, keyValue[1].length() - remove);
                keyValue[1] = keyValue[1].substring(1);
                map.put(keyValue[0], keyValue[1]);
            }

        }
if (map.containsKey(extraction)) { // if the map contains the key of sub then return the VALUR of
    // sub
    return map.get(extraction);
    }
    return null;

    }



}
