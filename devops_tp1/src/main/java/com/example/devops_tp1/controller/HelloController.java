package com.example.devops_tp1.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello() {
        if (true) {
        }
        System.out.println("hello there");
        return "hello";
    }
}