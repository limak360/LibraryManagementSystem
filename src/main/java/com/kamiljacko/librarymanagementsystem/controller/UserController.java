package com.kamiljacko.librarymanagementsystem.controller;


import com.kamiljacko.librarymanagementsystem.security.dto.PasswordDto;
import com.kamiljacko.librarymanagementsystem.security.dto.UserRegistrationDto;
import com.kamiljacko.librarymanagementsystem.security.model.User;
import com.kamiljacko.librarymanagementsystem.security.service.MailService;
import com.kamiljacko.librarymanagementsystem.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by Kamil Jacko <br>
 * A controller class allowing application users to log in, create an account, reset password
 */
@Controller
@RequestMapping("/users/")
public class UserController {

    private final UserService userService;
    private final MailService mailService;

    @Autowired
    public UserController(UserService userService, MailService mailService) {
        this.userService = userService;
        this.mailService = mailService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @ModelAttribute("password")
    public PasswordDto passwordDto() {
        return new PasswordDto();
    }

    @RequestMapping("login")
    public String login() {
        return "security/login";
    }

    @GetMapping("registration")
    public String showRegistrationForm() {
        return "security/registration";
    }

    @PostMapping("registration")
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userRegistrationDto,
                                      BindingResult result) {

        User existing = userService.findByUsername(userRegistrationDto.getUsername());
        if (existing != null) {
            result.rejectValue("username", null, "There is already an account registered with that username");
        }

        if (result.hasErrors()) {
            return "security/registration";
        }

        userService.save(userRegistrationDto);

        return "redirect:/users/registration?success";
    }


    //password reset
    @GetMapping("forgotPassword")
    public String showForgotPasswordForm() {
        return "security/password-forgot";
    }

    //todo
    @PostMapping("forgotPassword")
    public String forgotPassword(final HttpServletRequest request, @RequestParam("email") final String email) {

        User existing = userService.findByEmail(email);

        if (existing != null) {
            final String token = UUID.randomUUID().toString();
            userService.createPasswordResetTokenForUser(existing, token);
            mailService.sendMail(request, token, existing);
            return "redirect:/users/forgotPassword?success";
        }
//
        return "redirect:/users/forgotPassword?error";
    }

    @GetMapping("resetPassword")
    public String showResetPasswordForm(@RequestParam("token") final String token, Model model) {

        final String resetToken = userService.validatePasswordResetToken(token);

        if (resetToken != null) {
            model.addAttribute("token", token);
        }
        return "security/password-reset";
    }

    //
    @PostMapping("resetPassword")
    public String resetPassword(@ModelAttribute("password") @Valid PasswordDto passwordDto, BindingResult result) {

        final String token = userService.validatePasswordResetToken(passwordDto.getToken());

        if (token == null) {
            result.rejectValue("token", null, "Invalid token or token expired");
            return "security/password-reset";
        }

        Optional<User> user = userService.getUserByPasswordResetToken(passwordDto.getToken());

        if (!user.isPresent()) {
            result.rejectValue("token", null, "Invalid token");
            return "security/password-reset";
        }

        userService.changeUserPassword(user.get(), passwordDto.getNewPassword());

        return "redirect:/users/resetPassword?success";
    }
}