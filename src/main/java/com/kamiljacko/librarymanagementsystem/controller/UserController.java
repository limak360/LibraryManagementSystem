package com.kamiljacko.librarymanagementsystem.controller;


import com.kamiljacko.librarymanagementsystem.security.dto.UserRegistrationDto;
import com.kamiljacko.librarymanagementsystem.security.model.User;
import com.kamiljacko.librarymanagementsystem.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by Kamil Jacko <br>
 * A controller class allowing application users to log in, create an account, change password
 */
@Controller
@RequestMapping("/users/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @RequestMapping("login")
    public String login() {
        return "userauthorization/login";
    }

    @GetMapping("registration")
    public String showRegistrationForm() {
        return "userauthorization/registration";
    }

    @PostMapping("registration")
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userRegistrationDto,
                                      BindingResult result) {

        User existing = userService.findByUsername(userRegistrationDto.getUsername());
        if (existing != null) {
            result.rejectValue("username", null, "There is already an account registered with that username");
        }

        if (result.hasErrors()) {
            return "userauthorization/registration";
        }

        userService.save(userRegistrationDto);
        return "redirect:/users/registration?success";
    }

    @GetMapping("forgotPassword")
    public String showForgotPasswordForm() {
        return "userauthorization/password-forgot";
    }

    @PostMapping("forgotPassword")
    public String forgotPassword(@ModelAttribute("user") @Valid UserRegistrationDto userRegistrationDto,
                                 BindingResult result) {

        //todo findbyemail
        User existing = userService.findByUsername(userRegistrationDto.getUsername());
        if (existing == null) {
            result.rejectValue("username", null, "There is no account registered with that username");
        }

        if (result.hasErrors()) {
            return "userauthorization/password-forgot";
        }
        //sending an email with link and link must have some kind of token to tell who is the user
//        userService.

        return "redirect:/users/forgotPassword?success";
    }

    @GetMapping("resetPassword")
    public String showResetPasswordForm() {
        return "userauthorization/password-reset";
    }

    @PostMapping("resetPassword")
    public String resetPassword() {
        //check for token
        //form user provides new password

        return "redirect:/users/resetPassword?success";
    }
}