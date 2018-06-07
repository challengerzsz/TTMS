package com.bsb.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @PutMapping("/")
    public String hello(String i) {
        return i;
    }

}
