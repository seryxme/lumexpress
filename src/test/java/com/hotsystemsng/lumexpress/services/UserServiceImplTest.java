package com.hotsystemsng.lumexpress.services;

import com.hotsystemsng.lumexpress.data.dtos.requests.LoginRequest;
import com.hotsystemsng.lumexpress.data.models.Cart;
import com.hotsystemsng.lumexpress.data.models.Customer;
import com.hotsystemsng.lumexpress.data.repositories.CustomerRepository;
import com.hotsystemsng.lumexpress.services.notification.UserService;
import org.h2.engine.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@Sql("/customerInsert.sql")
class UserServiceImplTest {

    @Autowired
    private UserService userService;
    @Autowired
    private CustomerRepository customerRepository;
    private LoginRequest loginRequest;

    @BeforeEach
    void setUp() {
        Customer customer = new Customer();
        customer.setEmail("serikitunde1000@gmail.com");
        customer.setFirstName("Tee");
        customer.setLastName("Lex");
        customer.setPassword("12345");
        customer.setCart(new Cart());

        customerRepository.save(customer);

        loginRequest = LoginRequest.builder()
                .email("serikitunde1000@gmail.com")
                .password("12345")
                .build();

    }

    @Test
    void loginUserTest() {
        var response = userService.login(loginRequest);
        assertThat(response).isNotNull();
        assertThat(response.getCode()).isEqualTo(200);
    }
}