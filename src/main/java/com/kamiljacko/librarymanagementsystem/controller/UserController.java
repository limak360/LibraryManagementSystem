package com.kamiljacko.librarymanagementsystem.controller;


import com.kamiljacko.librarymanagementsystem.security.dto.UserRegistrationDto;
import com.kamiljacko.librarymanagementsystem.security.model.User;
import com.kamiljacko.librarymanagementsystem.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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
        return "login";
    }

    @GetMapping("registration")
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping("registration")
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
                                      BindingResult result) {

        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()) {
            return "registration";
        }

        userService.save(userDto);
        return "redirect:/users/registration?success";
    }

    @GetMapping("reset")
    public String showResetForm(Model model) {
        return "reset";
    }

    @PostMapping("reset")
    public String resetPassword(@RequestParam String email) {
        return "redirect:/users/login";
    }
}