package com.example.photoappusers.controller;

import com.example.photoappusers.dto.UserDto;
import com.example.photoappusers.model.CreateUserModel;
import com.example.photoappusers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RefreshScope
public class UserController {

    @Value("${test.output}")
    private String tester;

    @Autowired
    private UserService userService;

    @Autowired
    private Environment env;

    @GetMapping("/status/check")
    public String status(){
        return "Working..." + env.getProperty("local.server.port") + " -> " + tester;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.saveUser(userDto));
    }
}
