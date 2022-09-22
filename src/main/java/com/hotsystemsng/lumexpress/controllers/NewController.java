package com.hotsystemsng.lumexpress.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NewController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World.";
    }

    @GetMapping("/bye")
    public String bye() {
        return "Goodbye World.";
    }
}
