package com.kamiljacko.librarymanagementsystem.controller;


import com.kamiljacko.librarymanagementsystem.service.QueryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users/")
public class UserController {

    private final QueryExample queryExample;

    @Autowired
    public UserController(QueryExample queryExample) {
        this.queryExample = queryExample;
    }

    @RequestMapping("login")
    public String login() {
        return "login";
    }
    
    @PostMapping("reset")
    public String resetPassword(@RequestParam String email) {
        return "reset";
    }

    @GetMapping()
    public void save() {
        queryExample.saveAdmin();
    }
}