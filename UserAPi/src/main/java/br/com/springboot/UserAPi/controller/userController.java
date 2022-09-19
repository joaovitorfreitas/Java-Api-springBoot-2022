package br.com.springboot.UserAPi.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public class userController {


    @GetMapping("/")
    public String teste(){
        return "Hello World";
    }
}
