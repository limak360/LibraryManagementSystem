package com.kamiljacko.librarymanagementsystem.controller;


import com.kamiljacko.librarymanagementsystem.entity.AccountStatus;
import com.kamiljacko.librarymanagementsystem.entity.AccountUser;
import com.kamiljacko.librarymanagementsystem.security.ApplicationUserRole;
import com.kamiljacko.librarymanagementsystem.service.AccountUserService;
import com.kamiljacko.librarymanagementsystem.service.QueryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users/")
public class UserController {

    private final QueryExample queryExample;
    private final AccountUserService accountUserService;

    @Autowired
    public UserController(QueryExample queryExample, AccountUserService accountUserService) {
        this.queryExample = queryExample;
        this.accountUserService = accountUserService;
    }

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String register(Model model){
        AccountUser accountUser = new AccountUser();
        accountUser.setActive(true);
        accountUser.setApplicationUserRole(ApplicationUserRole.MEMBER);
        accountUser.setStatus(AccountStatus.ACTIVE);
        model.addAttribute("User", accountUser);

        return "registration";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute AccountUser accountUser) {
        accountUserService.save(accountUser);

        return "redirect:/users/registration";
    }

    @PostMapping("reset")
    public String resetPassword(@RequestParam String email) {
        return "reset";
    }
}