package com.kamiljacko.librarymanagementsystem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library/")
public class LibraryController {

    @GetMapping("books")
    public String getBooks(){
        return "main";
    }

    @GetMapping("books/bookId")
    public String getBook(){
        return "main";
    }

}