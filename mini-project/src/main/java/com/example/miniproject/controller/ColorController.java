package com.example.miniproject.controller;

import com.example.miniproject.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColorController {
    @Autowired
    private ColorService colorService;

    // Get http://locahost:8080/ramdom-color?type=[typevalue]
    @GetMapping("/random-color")
    public String randomColor(@RequestParam int type ){
        return colorService.ramdomColor(type);

    }
}
