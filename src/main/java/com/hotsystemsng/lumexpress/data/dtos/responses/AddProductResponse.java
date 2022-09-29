package com.hotsystemsng.lumexpress.data.dtos.responses;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AddProductResponse {
    private Long productId;
    private String message;
    private int code;
}
