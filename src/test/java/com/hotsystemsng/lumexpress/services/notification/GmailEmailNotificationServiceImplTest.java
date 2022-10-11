package com.hotsystemsng.lumexpress.services.notification;

import com.hotsystemsng.lumexpress.data.dtos.requests.EmailNotificationRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class GmailEmailNotificationServiceImplTest {

    @Autowired
    private EmailNotificationService emailNotificationService;

    @Test
    void sendHtmlMail() {
        EmailNotificationRequest emailNotification = new EmailNotificationRequest();
        emailNotification.setSubject("Welcome to LumExpress");
        emailNotification.setUserEmail("serikitunde1000@gmail.com");
        emailNotification.setEmailBody("Hello Lummie");
        String response = emailNotificationService.sendHtmlEmail(emailNotification);
        assertThat(response).contains("successfully");
    }

}