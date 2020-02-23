package com.telenor.greeting.account;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest
public class AccountGreetingTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void shouldReturnUserGreetingForPositiveIds() throws Exception {
        final String accountType = "personal";
        final int id = 123;
        mockMvc.perform(get("/account/" + accountType + "/id/" + id))
                .andExpect(status().isOk())
                .andExpect(content().string("Hi, userId "+id));

    }

    @Test
    public void shouldReturnNotFoundForBusinessAccountsWithId() throws Exception {
        final String accountType = "business";
        final int id = 123;
        mockMvc.perform(get("/account/" + accountType + "/id/" + id))
                .andExpect(status().isNotFound());

    }

    @Test
    public void shouldReturnBadRequestWithNegativeIds() throws Exception {
        final String accountType = "personal";
        final int id = -123;
        mockMvc.perform(get("/account/" + accountType + "/id/" + id))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void shouldReturnBadRequestWithInvalidAccountTypesAndWithIds() throws Exception {
        final String accountType = "wrongType";
        final int id = 123;
        mockMvc.perform(get("/account/" + accountType + "/id/" + id))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void shouldWelcomeBusinessAccountWithBigType() throws Exception {
        final String accountType = "business";
        final String type = "big";
        mockMvc.perform(get("/account/" + accountType + "/type/" + type))
                .andExpect(status().isOk())
                .andExpect(content().string("Welcome, business user!"));

    }

    @Test
    public void shouldReturnNotFoundForBusinessWithSmallTypes() throws Exception {
        final String accountType = "business";
        final String type = "small";
        mockMvc.perform(get("/account/" + accountType + "/type/" + type))
                .andExpect(status().isNotFound());

    }

    @Test
    public void shouldReturnBadRequestWithInvalidAccountTypesWithAnyType() throws Exception {
        final String accountType = "wrongType";
        final String type = "big";
        mockMvc.perform(get("/account/" + accountType + "/type/" + type))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void shouldReturnBadRequestWithInvalidTypes() throws Exception {
        final String accountType = "business";
        final String type = "wrongType";
        mockMvc.perform(get("/account/" + accountType + "/type/" + type))
                .andExpect(status().isBadRequest());

    }
}
