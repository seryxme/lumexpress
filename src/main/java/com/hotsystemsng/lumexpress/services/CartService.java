package com.hotsystemsng.lumexpress.services;

import com.hotsystemsng.lumexpress.data.dtos.requests.CartRequest;
import com.hotsystemsng.lumexpress.data.dtos.responses.CartResponse;
import com.hotsystemsng.lumexpress.data.models.Cart;
import com.hotsystemsng.lumexpress.exceptions.CartNotFoundException;

import java.util.List;

public interface CartService {
    CartResponse addProductToCart(CartRequest cartRequest) throws CartNotFoundException;
    List<Cart> getCartList();
}
