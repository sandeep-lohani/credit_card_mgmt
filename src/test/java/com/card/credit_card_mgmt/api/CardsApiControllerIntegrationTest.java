package com.card.credit_card_mgmt.api;

import com.card.credit_card_mgmt.CreditCardMgmtApplication;
import com.card.credit_card_mgmt.model.CreditCardRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = CreditCardMgmtApplication.class)
@AutoConfigureMockMvc
class CardsApiControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void givenCreditCard_whenAddCreditCard_thenStatus201() throws Exception {
        mvc.perform(post("/cards/credit-card")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new CreditCardRequest("Sandeep", "2222420000001113", 100D)))
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("Sandeep")))
                .andExpect(jsonPath("$.cardNumber", is("2222420000001113")))
                .andExpect(jsonPath("$.limit", is("£100.0")))
                .andExpect(jsonPath("$.balance", is("£0.0")));
    }

    @Test
    public void givenCardNo_whenGedCreditCard_thenStatus200() throws Exception {
        mvc.perform(get("/cards/credit-card")
                        .contentType(MediaType.APPLICATION_JSON)
                        .queryParam("creditCardNumber", "2222420000001113"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("Sandeep")))
                .andExpect(jsonPath("$.cardNumber", is("2222420000001113")))
                .andExpect(jsonPath("$.limit", is("£100.0")))
                .andExpect(jsonPath("$.balance", is("£0.0")));
    }

    @Test
    public void givenCards_whenGetCreditCards_thenStatus200() throws Exception {
        mvc.perform(get("/cards/credit-cards")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", is("Sandeep")))
                .andExpect(jsonPath("$[0].cardNumber", is("2222420000001113")))
                .andExpect(jsonPath("$[0].limit", is("£100.0")))
                .andExpect(jsonPath("$[0].balance", is("£0.0")));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}