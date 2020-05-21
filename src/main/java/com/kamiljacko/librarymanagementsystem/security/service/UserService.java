package com.kamiljacko.librarymanagementsystem.security.service;

import com.kamiljacko.librarymanagementsystem.security.dto.UserRegistrationDto;
import com.kamiljacko.librarymanagementsystem.security.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUsername(String username);

    User save(UserRegistrationDto registration);
}