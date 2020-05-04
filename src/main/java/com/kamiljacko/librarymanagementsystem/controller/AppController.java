package com.kamiljacko.librarymanagementsystem.controller;

import com.kamiljacko.librarymanagementsystem.service.QueryExample;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    QueryExample queryExample;

    @GetMapping("/hello")
    public String tempView() {
       // queryExample.simpleQuery();
        return "viewTest";
    }
}