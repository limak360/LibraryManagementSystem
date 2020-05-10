package com.kamiljacko.librarymanagementsystem.controller;


import com.kamiljacko.librarymanagementsystem.service.QueryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class ManagementController {

    private final QueryExample queryExample;

    @Autowired
    public ManagementController(QueryExample queryExample) {
        this.queryExample = queryExample;
    }

    @GetMapping("login")
    public String login(){

        return "login";
    }

    @GetMapping("save")
    public String save(){
        queryExample.saveAdmin();
        queryExample.saveLibrarian();
        queryExample.saveMember();
        return "";
    }

      //todo
//    @PostMapping("register")
//    public String register(@ModelAttribute UserDto userDto){

//        String encodedPassword  = passwordEncoder.encode(userDto.getPassword1());
//
//        User user = new User();
//        user.setEnabled(Boolean.TRUE);
//        user.setPassword(encodedPassword);
//        user.setUsername(userDto.getUsername());
//
//        UserAuthority boardAuthority = new UserAuthority();
//        boardAuthority.setAuthority("BOARD");
//        boardAuthority.setUser(user);
//        user.getAuthorities().add(boardAuthority);
//        userRepository.save(user);
//
//
//        return "login";
//    }

    @PostMapping("reset")
    public String resetPassword(@RequestParam String email){
        return "login";
    }
}