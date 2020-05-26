package com.kamiljacko.librarymanagementsystem.controller;


import com.kamiljacko.librarymanagementsystem.dto.BookDto;
import com.kamiljacko.librarymanagementsystem.entity.BookFormat;
import com.kamiljacko.librarymanagementsystem.entity.BookStatus;
import com.kamiljacko.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/books/")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("book")
    public BookDto bookDto() {
        return new BookDto();
    }

    @GetMapping("addBook")
    public String showAddBookForm(Model model) {

        model.addAttribute("BookFormat", BookFormat.values());
        model.addAttribute("BookStatus", BookStatus.values());

        return "mainview/add-book";
    }

    @PostMapping("addBook")
    public String addBook(@ModelAttribute("book") @Valid BookDto bookDto, BindingResult result) {

        if (result.hasErrors()) {
            return "mainview/add-book";
        }

        bookService.save(bookDto);

        return "redirect:/books/addBook?success";
    }
}