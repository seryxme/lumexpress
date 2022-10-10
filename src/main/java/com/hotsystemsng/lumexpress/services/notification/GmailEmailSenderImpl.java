package com.hotsystemsng.lumexpress.services.notification;

import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
@AllArgsConstructor
public class GmailEmailSenderImpl implements EmailSender {

    private final JavaMailSender javaMailSender;

    @Override
    public String sendHtmlEmail(EmailDetails emailDetails) {
        var mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
        try {
            messageHelper.setFrom("no-reply@lumexpress.com.ng");
            messageHelper.setTo(emailDetails.getUserEmail());
            messageHelper.setText(emailDetails.getEmailBody(), true);
            javaMailSender.send(mimeMessage);
            return String.format("Email sent to %s successfully!", emailDetails.getUserEmail());
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return String.format("Email not sent to %s!", emailDetails.getUserEmail());
    }
}
