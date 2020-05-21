package com.kamiljacko.librarymanagementsystem.security.dto;

import javax.validation.constraints.NotNull;

public class PasswordDto {

    private String oldPassword;
    private  String token;
    @NotNull
    private String newPassword;
}