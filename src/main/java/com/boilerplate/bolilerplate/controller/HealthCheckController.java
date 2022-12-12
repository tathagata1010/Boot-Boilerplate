package com.boilerplate.bolilerplate.controller;

import com.boilerplate.bolilerplate.utils.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    @Autowired
    Service service;

    @GetMapping("/check/{S}")
    public String healthCheck(@PathVariable String S){
        if(service.checkHealth(S)){
            return "In Good Health";
        }
        return "Not Working";
    }
}
