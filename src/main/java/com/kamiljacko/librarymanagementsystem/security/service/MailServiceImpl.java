package com.kamiljacko.librarymanagementsystem.security.service;


import com.kamiljacko.librarymanagementsystem.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

@Service
public class MailServiceImpl implements MailService {

    private final JavaMailSender mailSender;

    @Autowired
    public MailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendMail(final HttpServletRequest request, final String token, final User user) {

        final String html = "<h3>Hi! Click the link to reset your password.</h3>" +
                "<a href=" + getAppUrl(request) + "/users/resetPassword?token=" + token + ">reset password</a>";

        try {
            MimeMessage message = mailSender.createMimeMessage();
            message.setSubject("Password reset");

            MimeMessageHelper helper;
            helper = new MimeMessageHelper(message, true);
            helper.setFrom("from");
            helper.setTo(user.getEmail());
            helper.setText(html, true);

            mailSender.send(message);
        } catch (MessagingException ex) {
            //
        }
    }

    private String getAppUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}