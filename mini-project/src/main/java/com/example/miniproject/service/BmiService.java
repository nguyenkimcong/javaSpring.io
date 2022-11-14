package com.example.miniproject.service;

import com.example.miniproject.exception.BadRequestException;
import com.example.miniproject.request.BMIRequest;
import org.springframework.stereotype.Service;

@Service
public class BmiService {
    public double getBMI(double height, double weight) {
        if(height <= 0 || weight <= 0) {
            throw new BadRequestException("Cân nặng chiều cao phải lon hơn 0");
        }
        return weight/(height*height);
    }

    public double getBMIByPost(BMIRequest bmiRequest) {
        return getBMI(bmiRequest.getHeight(),bmiRequest.getWeight());
    }
}
