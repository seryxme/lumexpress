package com.hotsystemsng.lumexpress.data.dtos.requests;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationRequest {
    private Long userId;
    private String message;
}
