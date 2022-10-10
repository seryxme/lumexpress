package com.hotsystemsng.lumexpress.services.notification;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class GmailEmailSenderImplTest {

    @Autowired
    private EmailSender emailSender;

    @Test
    void sendHtmlMail() {
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setUserEmail("serikitunde1000@gmail.com");
        emailDetails.setEmailBody("Hello Lummie");
        String response = emailSender.sendHtmlEmail(emailDetails);
        assertThat(response).contains("successfully");
    }

}