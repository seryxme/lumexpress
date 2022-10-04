package com.hotsystemsng.lumexpress.services;

import com.cloudinary.utils.ObjectUtils;
import com.hotsystemsng.lumexpress.cloud.CloudService;
import com.hotsystemsng.lumexpress.data.dtos.requests.AddProductRequest;
import com.hotsystemsng.lumexpress.data.dtos.requests.GetAllItemsRequest;
import com.hotsystemsng.lumexpress.data.dtos.requests.UpdateProductRequest;
import com.hotsystemsng.lumexpress.data.dtos.responses.AddProductResponse;
import com.hotsystemsng.lumexpress.data.dtos.responses.UpdateProductResponse;
import com.hotsystemsng.lumexpress.data.models.Category;
import com.hotsystemsng.lumexpress.data.models.Product;
import com.hotsystemsng.lumexpress.data.repositories.ProductRepository;
import com.hotsystemsng.lumexpress.exceptions.ProductNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CloudService cloudService;
    private final ModelMapper mapper;

    @Override
    public AddProductResponse addProduct(AddProductRequest request) throws IOException {
        Product product = mapper.map(request, Product.class);
        product.getCategories().add(Category.valueOf(request.getCategory().toUpperCase()));
        String imageUrl = cloudService.upload(request.getImage().getBytes(), ObjectUtils.emptyMap());
        log.info("Cloudinary image URL :: {}", imageUrl);
        product.setImageUrl(imageUrl);
        Product savedProduct = productRepository.save(product);

        return buildCreateProductResponse(savedProduct);
    }

    private AddProductResponse buildCreateProductResponse(Product savedProduct) {
        return AddProductResponse.builder()
                .code(201)
                .productId(savedProduct.getId())
                .message("Product added successfully!")
                .build();
    }

    @Override
    public UpdateProductResponse updateProductDetails(UpdateProductRequest request) {
        var foundProduct = productRepository.findById(request.getProductId()).orElseThrow(
                ()-> new ProductNotFoundException(String.format("Product with ID %d is not present", request.getProductId()))
        );

        return null;
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(
                ()-> new ProductNotFoundException(String.format("Product with ID %d is not present", id))
        );
    }

    @Override
    public Page<Product> getAllProducts(GetAllItemsRequest request) {
        Pageable pageSpecs = PageRequest.of(request.getPageNumber() - 1, request.getNumberOfItemsPerPage());
        return productRepository.findAll(pageSpecs);
    }

    @Override
    public String deleteProduct(Long id) {
        return null;
    }
}
