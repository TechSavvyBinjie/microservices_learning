package top.yf.Service.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
@Resource
private RestTemplate restTemplate;
    @GetMapping("/user")
    public String getUser(@RequestParam String question) {
        String userServiceUrl="http://localhost:8084/ai?str="+question;
        String answer = restTemplate.getForObject(userServiceUrl, String.class);
        return answer;
    }
}