package top.yf.requestservice.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsymerController2 {
    @Resource
    private RestTemplate restTemplate;
    private  final String SERVICE_URL="http://localhost:8081";

    @GetMapping("test1")
    public String test(){
        return restTemplate.getForObject(SERVICE_URL+"/h1",String.class);
    }

}
