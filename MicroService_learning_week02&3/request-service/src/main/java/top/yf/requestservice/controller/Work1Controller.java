package top.yf.requestservice.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Work1Controller {
    @Resource
    private RestTemplate restTemplate;
    private  final String SERVICE_URL="https://wanandroid.com/harmony/index/json";

    @GetMapping("work01")
    public String test(){
        return restTemplate.getForObject(SERVICE_URL,String.class);
    }
}
