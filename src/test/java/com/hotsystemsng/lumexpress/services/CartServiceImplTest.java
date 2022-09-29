package com.hotsystemsng.lumexpress.services;

import com.hotsystemsng.lumexpress.data.models.Cart;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CartServiceImplTest {
    @Autowired
    private CartService cartService;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("test that cart can be created")
    void createCartTest() {
//        Cart cart = cartService.create();
//        assertThat(cart).isNotNull();

    }
}