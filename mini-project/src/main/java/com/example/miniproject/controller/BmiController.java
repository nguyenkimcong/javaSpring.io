package com.example.miniproject.controller;

import com.example.miniproject.request.BMIRequest;
import com.example.miniproject.service.BmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BmiController {
    @Autowired
    private BmiService bmiService;

    @GetMapping("bmi")
    public double getBmi(@RequestParam double height, @RequestParam double weight ) {
        return bmiService.getBMI(height, weight);
    }

    @PostMapping("bmi")
    public double getBMIByPost(@RequestBody BMIRequest bmiRequest){
        return bmiService.getBMIByPost(bmiRequest);
    }
}
