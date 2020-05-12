package com.kamiljacko.librarymanagementsystem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class RoleController {

    @GetMapping("admin")
    public String getAdminPage(){
        return "";
    }

}