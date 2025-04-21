package org.example.charityapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testcontrollers {
    @GetMapping("/hello")
    String hello() {
            return "Hello World !";
    }


}
