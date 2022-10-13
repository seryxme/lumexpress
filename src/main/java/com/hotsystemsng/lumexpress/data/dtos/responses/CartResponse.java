package com.hotsystemsng.lumexpress.data.dtos.responses;

import com.hotsystemsng.lumexpress.data.models.Cart;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartResponse {
    private String message;
    private Cart cart;
}
