package com.example.helloworld.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String greet(String name) {
        if (name == null || name.isBlank()) {
            throw new InvalidNameException("name is required");
        }

        String trimmed = name.strip();
        char first = Character.toUpperCase(trimmed.charAt(0));
        if (first < 'A' || first > 'M') {
            throw new InvalidNameException("name must start with a letter between A and M");
        }

        return "Hello " + first + trimmed.substring(1);
    }
}
