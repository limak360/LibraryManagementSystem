package com.kamiljacko.librarymanagementsystem.controller;


import com.kamiljacko.librarymanagementsystem.security.dto.PasswordDto;
import com.kamiljacko.librarymanagementsystem.security.dto.UserDto;
import com.kamiljacko.librarymanagementsystem.security.model.User;
import com.kamiljacko.librarymanagementsystem.security.service.MailService;
import com.kamiljacko.librarymanagementsystem.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public UserDto userDto() {
        return new UserDto();
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
    public String registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto,
                                      BindingResult result) {

        User existing = userService.findByUsername(userDto.getUsername());
        if (existing != null) {
            result.rejectValue("username", null, "There is already an account registered with that username");
        }

        existing = userService.findByEmail(userDto.getEmail());

        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()) {
            return "security/registration";
        }

        userService.save(userDto);

        return "redirect:/users/registration?success";
    }

    //password reset
    @GetMapping("forgotPassword")
    public String showForgotPasswordForm() {
        return "security/password-forgot";
    }


    @PostMapping("forgotPassword")
    public String forgotPassword(final HttpServletRequest request, @RequestParam("email") final String email) {

        User existing = userService.findByEmail(email);

        if (existing != null) {
            final String token = UUID.randomUUID().toString();
            userService.createPasswordResetTokenForUser(existing, token);
            mailService.sendMail(request, token, existing);
            return "redirect:/users/forgotPassword?success";
        }
        return "redirect:/users/forgotPassword?error";
    }

    @GetMapping("resetPassword")
    public String showResetPasswordForm(@RequestParam(required = false, value = "token") final String token, Model model) {

        final String resetToken = userService.validatePasswordResetToken(token);

        if (resetToken != null) {
            return "redirect:/users/login?Invalid";
        }

        model.addAttribute("token", token);

        return "security/password-reset";
    }

    @PostMapping("savePassword")
    public String resetPassword(@ModelAttribute("password") @Valid PasswordDto passwordDto, BindingResult result, RedirectAttributes redirectAttributes) {

        final String token = userService.validatePasswordResetToken(passwordDto.getToken());

        if (token != null) {
            return "redirect:/users/login?Invalid";
        }

        Optional<User> user = userService.getUserByPasswordResetToken(passwordDto.getToken());

        if (!user.isPresent()) {
            return "redirect:/users/login?Invalid";
        } else {
            userService.changeUserPassword(user.get(), passwordDto.getNewPassword());
        }

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute(BindingResult.class.getName() + ".password", result);
            redirectAttributes.addFlashAttribute("password", passwordDto);
            return "redirect:/users/resetPassword?token=" + passwordDto.getToken();
        }

        return "redirect:/users/login?resetSuccess";
    }
}