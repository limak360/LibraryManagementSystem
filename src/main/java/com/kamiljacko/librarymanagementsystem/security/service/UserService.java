package com.kamiljacko.librarymanagementsystem.security.service;

import com.kamiljacko.librarymanagementsystem.security.dto.UserRegistrationDTO;
import com.kamiljacko.librarymanagementsystem.security.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDTO registration);
}