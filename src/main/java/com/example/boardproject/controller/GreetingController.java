package com.example.boardproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @GetMapping("/main")
    public String niceToMeetYou(Model model){
        model.addAttribute("username","Steve");
        return "greetings";
    }

    @GetMapping("/bye")
    public String seeYouLater(Model model){
        model.addAttribute("username","Steve");
        return "goodbye";
    }
}
