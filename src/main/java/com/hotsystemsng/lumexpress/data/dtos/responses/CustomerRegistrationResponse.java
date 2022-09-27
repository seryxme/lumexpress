package com.hotsystemsng.lumexpress.data.dtos.responses;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRegistrationResponse {
    private Long userId;
    private String message;
    private int code;
}
