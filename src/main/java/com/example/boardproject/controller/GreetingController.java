package com.example.boardproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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


    @GetMapping("/hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);

        return hello; //객체 반환하면 스프링이 자동으로 JSON 타입으로 타입변경 반환
    }

    static class Hello{
        private String name;

        public String getName(){
            return name;

        }
        public  void setName(String name){
            this.name = name;
        }
    }
}
