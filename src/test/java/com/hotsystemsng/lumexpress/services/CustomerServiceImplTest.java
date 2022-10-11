package com.hotsystemsng.lumexpress.services;

import com.hotsystemsng.lumexpress.data.dtos.requests.CustomerRegistrationRequest;
import com.hotsystemsng.lumexpress.data.dtos.responses.CustomerRegistrationResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerServiceImplTest {
    @Autowired
    private CustomerService customerService;
    private CustomerRegistrationRequest request;
    @BeforeEach
    void setUp() {
        request = CustomerRegistrationRequest
                .builder()
                .email("serikitunde1000@gmail.com")
                .password("MyP@ssword")
                .country("Nigeria")
                .build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void registerCustomerTest() {
        CustomerRegistrationResponse response = customerService.register(request);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isNotNull();
        assertThat(response.getUserId()).isGreaterThan(0);
        assertThat(response.getCode()).isEqualTo(201);
    }

    @Test
    void completeProfile() {
    }
}