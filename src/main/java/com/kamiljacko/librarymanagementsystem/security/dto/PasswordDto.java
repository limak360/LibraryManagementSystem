package com.kamiljacko.librarymanagementsystem.security.dto;

import com.kamiljacko.librarymanagementsystem.security.constrain.FieldMatch;

import javax.validation.constraints.NotEmpty;

@FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match")
public class PasswordDto {

    private String token;
    @NotEmpty
    private String newPassword;
    @NotEmpty
    private String confirmNewPassword;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }
}