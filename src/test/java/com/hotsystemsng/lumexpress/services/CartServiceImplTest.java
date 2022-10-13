package com.hotsystemsng.lumexpress.services;

import com.hotsystemsng.lumexpress.data.dtos.requests.CartRequest;
import com.hotsystemsng.lumexpress.data.dtos.requests.GetAllItemsRequest;
import com.hotsystemsng.lumexpress.data.dtos.responses.CartResponse;
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

    @Autowired
    private ProductService productService;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Test that product can be added to cart.")
    void addProductToCartTest() {
        CartRequest cartRequest = CartRequest.builder()
                .cartId(cartService.getCartList().get(cartService.getCartList().size()-1).getId())
                .productId(productService.getAllProducts(new GetAllItemsRequest())
                        .getContent().get(productService.getAllProducts(new GetAllItemsRequest())
                                .getNumberOfElements()-1).getId())
                .build();

        CartResponse response = cartService.addProductToCart(cartRequest);
    }
}