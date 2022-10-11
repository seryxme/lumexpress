package com.hotsystemsng.lumexpress.data.repositories;

import com.hotsystemsng.lumexpress.data.models.Cart;
import com.hotsystemsng.lumexpress.data.models.Customer;
import com.hotsystemsng.lumexpress.data.models.LumExpressUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;
    @BeforeEach
    void setUp() {
        customerRepository.deleteAll();
    }

    @Test
    void findByEmail() {
        Customer customer = new Customer();
        customer.setEmail("serikitunde1000@gmail.com");
        customer.setFirstName("Tee");
        customer.setLastName("Lex");
        customer.setPassword("12345");
        customer.setCart(new Cart());

        Customer savedCustomer = customerRepository.save(customer);
        assertThat(customerRepository.findByEmail(customer.getEmail())).isNotNull();
        assertThat(savedCustomer.getId()).isGreaterThan(0L);
    }
}