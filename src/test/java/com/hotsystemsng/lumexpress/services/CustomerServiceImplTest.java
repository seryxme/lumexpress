package com.hotsystemsng.lumexpress.services;

import com.hotsystemsng.lumexpress.data.dtos.requests.CustomerRegistrationRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerServiceImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void register() {
        CustomerRegistrationRequest request = CustomerRegistrationRequest
                                                .builder()
                                                .email("me@gmail.com")
                                                .password("MyP@ssword")
                                                .country("Nigeria")
                                                .build();
    }

    @Test
    void login() {
    }

    @Test
    void completeProfile() {
    }
}