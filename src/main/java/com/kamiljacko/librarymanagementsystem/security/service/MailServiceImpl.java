package com.kamiljacko.librarymanagementsystem.security.service;


import com.kamiljacko.librarymanagementsystem.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

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
        System.out.println(constructResetTokenEmail(getAppUrl(request), token, user).toString());
       // mailSender.send(constructResetTokenEmail(getAppUrl(request), token, user));
    }
//
    private SimpleMailMessage constructResetTokenEmail(final String contextPath, final String token, final User user) {
        final String url = contextPath + "/users/resetPassword?token=" + token;
        final String message = "Click link to reset your password";
        return constructEmail("Password reset", message + " \r\n" + url, user);
    }

    private SimpleMailMessage constructEmail(String subject, String body, User user) {
        final SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject(subject);
        email.setText(body);
        email.setTo(user.getEmail());
        email.setFrom(System.getProperty("support.email"));
        return email;
    }

    private String getAppUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}