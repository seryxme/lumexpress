package com.hotsystemsng.lumexpress.services.notification;

import com.hotsystemsng.lumexpress.data.dtos.requests.NotificationRequest;

public interface NotificationService {
    String send(NotificationRequest request);
}
