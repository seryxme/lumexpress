package com.hotsystemsng.lumexpress.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.hotsystemsng.lumexpress.data.dtos.requests.AddProductRequest;
import com.hotsystemsng.lumexpress.data.dtos.requests.GetAllItemsRequest;
import com.hotsystemsng.lumexpress.data.dtos.requests.UpdateProductRequest;
import com.hotsystemsng.lumexpress.data.dtos.responses.AddProductResponse;
import com.hotsystemsng.lumexpress.data.dtos.responses.UpdateProductResponse;
import com.hotsystemsng.lumexpress.data.models.Product;
import com.hotsystemsng.lumexpress.exceptions.ProductNotFoundException;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    AddProductResponse addProduct(AddProductRequest request) throws IOException;

    UpdateProductResponse updateProductDetails(Long productId, JsonPatch patch) throws JsonProcessingException, JsonPatchException, ProductNotFoundException;

    Product getProduct(Long id) throws ProductNotFoundException;

    Page<Product> getAllProducts(GetAllItemsRequest request);

    String deleteProduct(Long id);
}
