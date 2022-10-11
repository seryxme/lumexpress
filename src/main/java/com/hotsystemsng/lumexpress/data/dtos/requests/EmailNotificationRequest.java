package com.hotsystemsng.lumexpress.data.dtos.requests;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailNotificationRequest {
    private String userEmail;
    private String emailBody;
    private String subject;
}
