package com.example.account.photoappaccountmanagement.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Value("${test.output}")
    private String tester;

    @GetMapping("/status/check")
    public String status(){
        return "Working..." + " -> " + tester ;
    }
}

