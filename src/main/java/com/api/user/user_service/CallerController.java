package com.api.user.user_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CallerController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/api/test-user")
    public String testUser() {
        return "Response from user-service";
    }

    @GetMapping("/api/test")
    public String test() {
        return "Response from user-service new";
    }

    @GetMapping("/api/call-order")
    public String callServiceB() {
        String response = restTemplate.getForObject("http://localhost:8082/api/hello", String.class);
        return "Response from B: " + response;
    }
}