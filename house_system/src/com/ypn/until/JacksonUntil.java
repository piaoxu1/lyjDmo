package com.ypn.until;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.ObjectInputValidation;

/**
 * @author ypn
 * @date 2020/8/14
 * @motto I raise pigs in your field
 * @desc
 */
public class JacksonUntil {
    private final static ObjectMapper o = new ObjectMapper();

    public JacksonUntil() {
        super();
    }

    public static String obj2Json(Object obj) {
        try {
            return o.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
