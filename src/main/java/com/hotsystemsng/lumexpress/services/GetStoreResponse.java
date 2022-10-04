package com.hotsystemsng.lumexpress.services;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetStoreResponse {
    private Long storeId;
    private int code;
    private String storeName;
}
