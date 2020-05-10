package com.kamiljacko.librarymanagementsystem.controller;


import com.kamiljacko.librarymanagementsystem.service.QueryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class ApiController {

    private final QueryExample queryExample;

    @Autowired
    public ApiController(QueryExample queryExample) {
        this.queryExample = queryExample;
    }

    @GetMapping("/main")
    public String getBookItem(Model model) {
       // model.addAttribute("list", queryExample.getBookItem());
        return "main";
    }

    @ResponseBody
    @GetMapping("/main/nic")
    private String getNic(){
        return "nic";
    }

    @ResponseBody
    @GetMapping("/lib")
    private String getLib(){
        return "Librarian page";
    }

    @ResponseBody
    @GetMapping("/admin")
    private String getAdminPage(){
        return "admin page";
    }
}