package com.kamiljacko.librarymanagementsystem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library/main")
public class LibraryController {

    @GetMapping
    public String getMainView() {
        return "mainview/main";
    }

//    @GetMapping("books/bookId")
//    public String getBook() {
//        return "redirect:/...";
//    }

    @GetMapping("/form")
    public String showAddBookForm(Model model) {
        return "";
    }
}