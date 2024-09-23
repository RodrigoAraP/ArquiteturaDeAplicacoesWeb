package com.example.RestAPI.controller;

import com.example.RestAPI.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class Controller {
    
    Service service = new Service();

    @GetMapping("/test")
    public String helloWorld(){
        return service.welcomeMessage();
    }

    @GetMapping("/exemplo")
    public String exemplo() {
        return service.exampleMessage();
    }

    @GetMapping("/clima")
    public String preverTempo() {
        return service.preverTempo();
    }  
}
