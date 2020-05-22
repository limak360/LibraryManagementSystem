package com.kamiljacko.librarymanagementsystem.security.service;


import com.kamiljacko.librarymanagementsystem.security.model.User;

import javax.servlet.http.HttpServletRequest;

public interface MailService {

    void sendMail(HttpServletRequest request, final String token, final User user);

}
