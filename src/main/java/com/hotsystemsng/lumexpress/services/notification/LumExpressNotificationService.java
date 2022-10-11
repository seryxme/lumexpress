package com.hotsystemsng.lumexpress.services.notification;

import com.hotsystemsng.lumexpress.data.dtos.requests.NotificationRequest;

public interface LumExpressNotificationService {
    String send(NotificationRequest request);
}
