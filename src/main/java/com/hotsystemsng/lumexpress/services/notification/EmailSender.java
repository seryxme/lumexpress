package com.hotsystemsng.lumexpress.services.notification;

public interface EmailSender {
    String sendHtmlEmail(EmailDetails emailDetails);
}
