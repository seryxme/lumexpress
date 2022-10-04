package com.hotsystemsng.lumexpress.services;

import com.cloudinary.utils.ObjectUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
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
    private final ObjectMapper objectMapper = new ObjectMapper();


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
    public UpdateProductResponse updateProductDetails(Long productId, JsonPatch patch) {
        var foundProduct = productRepository.findById(productId).orElseThrow(
                ()-> new ProductNotFoundException(String.format("Product with ID %d is not present", productId))
        );

        Product updatedProduct = applyPatchToProduct(patch, foundProduct);

        Product savedProduct = productRepository.save(updatedProduct);

        return buildUpdateResponse(savedProduct);
    }

    private Product applyPatchToProduct(JsonPatch patch, Product foundProduct) {
        try {
            JsonNode node = objectMapper.convertValue(foundProduct, JsonNode.class);
            JsonNode patchedNode = patch.apply(node);
            return objectMapper.treeToValue(patchedNode, Product.class);
        } catch (JsonPatchException |JsonProcessingException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private UpdateProductResponse buildUpdateResponse(Product savedProduct) {
        return UpdateProductResponse.builder()
                .price(savedProduct.getPrice())
                .description(savedProduct.getDescription())
                .productName(savedProduct.getName())
                .statusCode(201)
                .message("Product updated successfully")
                .build();
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
