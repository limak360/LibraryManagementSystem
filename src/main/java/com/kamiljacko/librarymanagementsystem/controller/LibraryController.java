package com.kamiljacko.librarymanagementsystem.controller;

import com.kamiljacko.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library/")
public class LibraryController {

    private final BookService bookService;

    @Autowired
    public LibraryController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("main")
    public String getMainView(Model model) {
        model.addAttribute("listOfBooks", bookService.findAll());
        return "mainview/main";
    }
}
