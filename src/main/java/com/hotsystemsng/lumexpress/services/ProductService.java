package com.hotsystemsng.lumexpress.services;

import com.hotsystemsng.lumexpress.data.dtos.requests.AddProductRequest;
import com.hotsystemsng.lumexpress.data.dtos.requests.UpdateProductRequest;
import com.hotsystemsng.lumexpress.data.dtos.responses.AddProductResponse;
import com.hotsystemsng.lumexpress.data.models.Product;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    AddProductResponse addProduct(AddProductRequest request) throws IOException;
    String updateProductDetails(UpdateProductRequest request);
    Product getProduct(Long id);
    Page<Product> getAllProducts();
    String deleteProduct(Long id);
}
