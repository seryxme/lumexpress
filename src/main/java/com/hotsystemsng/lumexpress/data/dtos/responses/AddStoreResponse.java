package com.hotsystemsng.lumexpress.data.dtos.responses;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddStoreResponse {
    private Long storeId;
    private int code;
    private String message;
}
