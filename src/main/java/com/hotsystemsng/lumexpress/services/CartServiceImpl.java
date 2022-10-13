package com.hotsystemsng.lumexpress.services;

import com.hotsystemsng.lumexpress.data.dtos.requests.CartRequest;
import com.hotsystemsng.lumexpress.data.dtos.responses.CartResponse;
import com.hotsystemsng.lumexpress.data.models.Cart;
import com.hotsystemsng.lumexpress.data.models.Item;
import com.hotsystemsng.lumexpress.data.models.Product;
import com.hotsystemsng.lumexpress.data.repositories.CartRepository;
import com.hotsystemsng.lumexpress.exceptions.CartNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final ProductService productService;


    @Override
    public CartResponse addProductToCart(CartRequest cartRequest) {
        Cart foundCart = cartRepository.findById(cartRequest.getCartId()).orElseThrow(
                ()-> new CartNotFoundException(String.format("Cart with ID %d not found.", cartRequest.getCartId())));
        Product foundProduct = productService.getProduct(cartRequest.getProductId());

        Item item = buildCartItem(foundProduct);
        foundCart.getItems().add(item);
        Cart savedCart = cartRepository.save(updateCartSubTotal(foundCart));



        return CartResponse.builder()
                .message("Item added successfully!")
                .cart(savedCart)
                .build();
    }

    @Override
    public List<Cart> getCartList() {
        return cartRepository.findAll();
    }

    private Cart updateCartSubTotal(Cart cart) {

        cart.getItems().forEach(item -> {
            var itemPrice = item.getProduct().getPrice();
            cart.setSubtotal(itemPrice.add(cart.getSubtotal()));
        });
        return cart;
    }

    private Item buildCartItem(Product foundProduct) {
        return Item.builder()
                .product(foundProduct)
                .quantity(1)
                .build();
    }
}
