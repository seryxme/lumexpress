package com.hotsystemsng.lumexpress.services;

import com.hotsystemsng.lumexpress.data.models.Cart;
import com.hotsystemsng.lumexpress.data.repositories.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;


}
