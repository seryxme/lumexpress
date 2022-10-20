package com.hotsystemsng.lumexpress.services;

import com.hotsystemsng.lumexpress.data.dtos.requests.AddProductRequest;
import com.hotsystemsng.lumexpress.data.dtos.requests.CartRequest;
import com.hotsystemsng.lumexpress.data.dtos.requests.CustomerRegistrationRequest;
import com.hotsystemsng.lumexpress.data.dtos.requests.GetAllItemsRequest;
import com.hotsystemsng.lumexpress.data.dtos.responses.CartResponse;
import com.hotsystemsng.lumexpress.data.dtos.responses.CustomerRegistrationResponse;
import com.hotsystemsng.lumexpress.data.models.Cart;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CartServiceImplTest {
    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;
    private CustomerRegistrationRequest request;
    private AddProductRequest productRequest;

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Test that product can be added to cart.")
    void addProductToCartTest() {
        CartRequest cartRequest = CartRequest.builder()
                .cartId(cartService.getCartList().get(cartService.getCartList().size()-1).getId())
                .productId(productService.getAllProducts(GetAllItemsRequest.builder().pageNumber(1).numberOfItemsPerPage(10).build())
                        .getContent().get(productService.getAllProducts(GetAllItemsRequest.builder().pageNumber(1).numberOfItemsPerPage(10).build())
                                .getNumberOfElements()-1).getId())
                .build();

        CartResponse response = cartService.addProductToCart(cartRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isNotNull();
        assertThat(response.getCart()).isNotNull();
        assertThat(response.getCart().getSubtotal()).isEqualTo(BigDecimal.valueOf(180.00).setScale(2, RoundingMode.DOWN));
    }
}