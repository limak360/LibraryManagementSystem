package com.kamiljacko.librarymanagementsystem.security.service;

import com.kamiljacko.librarymanagementsystem.security.dto.UserDto;
import com.kamiljacko.librarymanagementsystem.security.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {

    User findByUsername(String username);

    User findByEmail(String email);

    void save(UserDto registration);

    void changeUserPassword(User user, String password);

    void createPasswordResetTokenForUser(final User user, final String token);

    String validatePasswordResetToken(String token);

    Optional<User> getUserByPasswordResetToken(String token);
}