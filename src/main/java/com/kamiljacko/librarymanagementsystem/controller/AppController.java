package com.kamiljacko.librarymanagementsystem.controller;


import com.kamiljacko.librarymanagementsystem.service.QueryExample;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    private final QueryExample queryExample;
    
    public AppController(QueryExample queryExample) {
        this.queryExample = queryExample;
    }

    @GetMapping("/save")
    public String save() {
        queryExample.saveMember();
        queryExample.saveLibrarian();
        queryExample.saveBookItem();
        System.out.println("====================");
        return "main-view";
    }

    @GetMapping("/get")
    public String getAccounts() {
        System.out.println("====================");
        queryExample.getAccounts();
        return "main-view";
    }

    @GetMapping("/getBookItem")
    public String getBookItem(Model model) {
        model.addAttribute("list", queryExample.getBookItem());
        System.out.println("====================");
        queryExample.getBookItems();
        return "main-view";
    }

    @GetMapping("/cos")
    public String login(Model model){
        return "login-page";
    }

    @GetMapping("/register")
    public String registerMember(Model model){
        return "register-member";
    }

    @GetMapping("/reset")
    public String resetPassword(Model model){
        return "reset-password";
    }
}