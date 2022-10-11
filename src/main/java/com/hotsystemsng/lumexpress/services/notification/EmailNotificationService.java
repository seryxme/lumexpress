package com.hotsystemsng.lumexpress.services.notification;

import com.hotsystemsng.lumexpress.data.dtos.requests.EmailNotificationRequest;

public interface EmailNotificationService {
    String sendHtmlEmail(EmailNotificationRequest emailNotification);
}
