package com.hotsystemsng.lumexpress.services.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails {
    private String userEmail;
    private String emailBody;
}
