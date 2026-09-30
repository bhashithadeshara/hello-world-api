package com.example.helloworld.web;

import com.example.helloworld.dto.MessageResponse;
import com.example.helloworld.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private final GreetingService greetingService;

    public HelloWorldController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello-world")
    public MessageResponse helloWorld(@RequestParam(required = false) String name) {
        return new MessageResponse(greetingService.greet(name));
    }
}
