package com.hotsystemsng.lumexpress.services;

import com.hotsystemsng.lumexpress.data.dtos.requests.AddProductRequest;
import com.hotsystemsng.lumexpress.data.dtos.requests.GetAllItemsRequest;
import com.hotsystemsng.lumexpress.data.dtos.responses.AddProductResponse;
import com.hotsystemsng.lumexpress.data.models.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ProductServiceImplTest {
    @Autowired
    private ProductService productService;
    private AddProductRequest request;

    @BeforeEach
    void setUp() throws IOException {
        Path path = Paths.get("C:\\Users\\DELL\\Downloads\\fizzy.jpg");
        MultipartFile file = new MockMultipartFile("fizzy.jpg", Files.readAllBytes(path));
        request = AddProductRequest.builder()
                .name("Bigi-Cola")
                .category("Beverages")
                .price(BigDecimal.valueOf(30.00))
                .quantity(10)
                .image(file)
                .build();
    }

    @Test
    void create() throws IOException {
        AddProductResponse response = productService.addProduct(request);
        assertThat(response).isNotNull();
        assertThat(response.getProductId()).isGreaterThan(0L);
        assertThat(response.getMessage()).isNotNull();
        assertThat(response.getCode()).isEqualTo(201);

    }

    @Test
    void updateProductDetails() {

    }

    @Test
    void getProduct() throws IOException {
        var response = productService.addProduct(request);
        Product foundProduct = productService.getProduct(response.getProductId());
        assertThat(foundProduct).isNotNull();
        assertThat(foundProduct.getId()).isEqualTo(response.getProductId());
    }

    @Test
    void getAllProducts() throws IOException {
        productService.addProduct(request);
        var itemsRequest = GetAllItemsRequest
                .builder()
                .numberOfItemsPerPage(8)
                .pageNumber(1)
                .build();
        Page<Product> productsPage = productService.getAllProducts(itemsRequest);

        assertThat(productsPage).isNotNull();
        assertThat(productsPage.getTotalElements()).isGreaterThan(0L);
    }

    @Test
    void deleteProduct() {
    }
}