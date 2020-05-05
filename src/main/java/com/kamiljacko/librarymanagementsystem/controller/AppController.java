package com.kamiljacko.librarymanagementsystem.controller;

import com.kamiljacko.librarymanagementsystem.service.QueryExample;
import org.springframework.stereotype.Controller;
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
        return "viewTest";
    }

    @GetMapping("/get")
    public String getAccounts() {
        System.out.println("====================");
        queryExample.getAccounts();
        return "viewTest";
    }

    @GetMapping("/getBookItems")
    public String getBookItems() {
        System.out.println("====================");
        queryExample.getBookItems();
        return "viewTest";
    }
}