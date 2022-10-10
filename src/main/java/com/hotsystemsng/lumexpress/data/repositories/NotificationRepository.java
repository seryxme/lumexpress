package com.hotsystemsng.lumexpress.data.repositories;

import com.hotsystemsng.lumexpress.data.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
