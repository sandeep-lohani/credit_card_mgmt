package com.card.credit_card_mgmt.api;

import com.card.credit_card_mgmt.model.ErrorDetails;
import com.card.credit_card_mgmt.model.ErrorMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class ApiUtil {

    static ObjectMapper objectMapper = new ObjectMapper();
    public static void setErrorResponse(NativeWebRequest req, String contentType, ErrorMessage errorMsg) {
        try {
            ErrorDetails errorDetails = ErrorDetails.builder().message(errorMsg.getMessage()).timestamp(new Date()).build();
            HttpServletResponse res = req.getNativeResponse(HttpServletResponse.class);
            res.setCharacterEncoding("UTF-8");
            res.addHeader("Content-Type", contentType);
            res.getWriter().print(errorDetails.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setExampleResponse(NativeWebRequest req, String contentType, String example) {
        try {
            HttpServletResponse res = req.getNativeResponse(HttpServletResponse.class);
            res.setCharacterEncoding("UTF-8");
            res.addHeader("Content-Type", contentType);
            res.getWriter().print(example);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //using luhn10 algo to validate the card number
    public static boolean validateCardNumber(String cardNo) {
        int totalLen = cardNo.length();

        int sum = 0;
        boolean isSecond = false;
        for (int i = totalLen - 1; i >= 0; i--)
        {
            int d = cardNo.charAt(i) - '0';

            if (isSecond == true)
                d = d * 2;

            sum += d / 10;
            sum += d % 10;

            isSecond = !isSecond;
        }
        return (sum % 10 == 0);
    }
    public static String toJson(Object o){
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
