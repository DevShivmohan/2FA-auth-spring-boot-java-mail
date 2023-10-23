package com.mail.fa.utility;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
public class ResponseUtil {

    public static String generate() {
        final var response = new JSONObject();
        try {
            response.put("response", "This is custom response");
        } catch (JSONException e) {
            log.error("Unable to generate JSON response");
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
        }
        return response.toString();
    }

}
