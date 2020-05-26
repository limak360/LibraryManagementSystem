package com.kamiljacko.librarymanagementsystem.security.dto;

import com.kamiljacko.librarymanagementsystem.security.constrain.FieldMatch;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match")
public class UserDto {

    @NotEmpty
    private String username;
    @Email
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    @NotEmpty
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}