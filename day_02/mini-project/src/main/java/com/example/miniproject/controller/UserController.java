package com.example.miniproject.controller;

import com.example.miniproject.request.UserRequest;
import com.example.miniproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("login")

    public String getUser(@RequestBody UserRequest userRequest){

        return userService.getUser(userRequest);
    }
}
