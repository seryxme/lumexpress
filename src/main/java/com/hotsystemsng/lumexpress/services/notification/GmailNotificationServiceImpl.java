package com.hotsystemsng.lumexpress.services.notification;

import com.hotsystemsng.lumexpress.data.dtos.requests.EmailNotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
@AllArgsConstructor
public class GmailNotificationServiceImpl implements EmailNotificationService {

    private final JavaMailSender javaMailSender;

    @Override
    public String sendHtmlEmail(EmailNotificationRequest emailNotification) {
        var mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
        try {
            messageHelper.setFrom("no-reply@lumexpress.com.ng");
            messageHelper.setSubject(emailNotification.getSubject());
            messageHelper.setTo(emailNotification.getUserEmail());
            messageHelper.setText(emailNotification.getEmailBody(), true);
            javaMailSender.send(mimeMessage);
            return String.format("Email sent to %s successfully!", emailNotification.getUserEmail());
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return String.format("Email not sent to %s!", emailNotification.getUserEmail());
    }
}
