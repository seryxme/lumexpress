package com.hotsystemsng.lumexpress.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotsystemsng.lumexpress.data.dtos.requests.CustomerRegistrationRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {
    private CustomerRegistrationRequest request;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        request = CustomerRegistrationRequest
                .builder()
                .firstName("Tee")
                .email("serikitunde@1000gmail.com")
                .password("MyP@ssword")
                .country("Nigeria")
                .build();
    }

    @Test
    void registerControllerTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/v1/customer/register")
                .contentType("application/json")
                .content(mapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().is(201))
                .andDo(print());
    }
}