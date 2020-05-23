package com.kamiljacko.librarymanagementsystem.security.service;


import com.kamiljacko.librarymanagementsystem.security.model.User;

import javax.servlet.http.HttpServletRequest;

public interface MailService {

    void sendMail(final HttpServletRequest request, final String token, final User user);

}
