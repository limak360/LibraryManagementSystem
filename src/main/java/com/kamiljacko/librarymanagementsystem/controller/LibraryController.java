package com.kamiljacko.librarymanagementsystem.controller;

import com.kamiljacko.librarymanagementsystem.dto.BookDto;
import com.kamiljacko.librarymanagementsystem.dto.LibraryCardDto;
import com.kamiljacko.librarymanagementsystem.service.BookService;
import com.kamiljacko.librarymanagementsystem.service.LibraryCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/library/")
public class LibraryController {

    private final BookService bookService;
    private final LibraryCardService libraryCardService;

    @ModelAttribute("card")
    public LibraryCardDto libraryCardDto() {
        return new LibraryCardDto();
    }

    @Autowired
    public LibraryController(BookService bookService, LibraryCardService libraryCardService) {
        this.bookService = bookService;
        this.libraryCardService = libraryCardService;
    }

    @GetMapping("main")
    public String getMainView(@RequestParam(required = false, value = "search") final String title, Model model) {

        if (title != null) {
            if (title.equals("")) {
                return "redirect:/library/main?error";
            } else {
                model.addAttribute("listOfBooks", bookService.findByTitle(title));
                model.addAttribute("category", bookService.findAll());
            }
        } else {
            model.addAttribute("listOfBooks", bookService.findAll());
            model.addAttribute("category", bookService.findAll());
        }

        return "mainview/main";
    }

    @GetMapping("card")
    public String libraryCard() {

        //if card was issueed show card info

        return "mainview/library-card";
    }

    @PostMapping("card")
    public String libraryCard(@ModelAttribute("card") @Valid LibraryCardDto libraryCard, BindingResult result){

        libraryCardService.save(libraryCard);

        return "redirect: /library/card";
    }
}
