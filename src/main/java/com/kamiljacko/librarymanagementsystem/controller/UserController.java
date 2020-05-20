package com.kamiljacko.librarymanagementsystem.controller;


import com.kamiljacko.librarymanagementsystem.security.dto.UserRegistrationDTO;
import com.kamiljacko.librarymanagementsystem.security.model.User;
import com.kamiljacko.librarymanagementsystem.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public UserRegistrationDTO userRegistrationDto() {
        return new UserRegistrationDTO();
    }

    @RequestMapping("login")
    public String login() {
        return "userauthorization/login";
    }

    @GetMapping("registration")
    public String showRegistrationForm(Model model) {
        return "userauthorization/registration";
    }

    @PostMapping("registration")
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDTO userDto,
                                      BindingResult result) {

        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()) {
            return "userauthorization/registration";
        }

        userService.save(userDto);
        return "redirect:/users/registration?success";
    }
}