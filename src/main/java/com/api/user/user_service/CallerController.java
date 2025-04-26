package com.api.user.user_service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
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

        log.info("calling order service from user service");
        String response = restTemplate.getForObject("http://order-service:8082/api/hello", String.class);
        return "Response from B: " + response;
    }
}