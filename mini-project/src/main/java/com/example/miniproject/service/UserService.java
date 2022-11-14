package com.example.miniproject.service;

import com.example.miniproject.exception.NotFoundException;
import com.example.miniproject.model.User;
import com.example.miniproject.repository.UserRepository;
import com.example.miniproject.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String getUser(UserRequest userRequest) {
        if (userRepository.findByRequest(userRequest).isEmpty()) throw new NotFoundException("username or password fall");
        User user = userRepository.findByRequest(userRequest).get();
        return "username : "  + user.getUsername()
                + "\n email : " + user.getEmail()
                + "\n avatar : " + user.getAvatar();
}}
