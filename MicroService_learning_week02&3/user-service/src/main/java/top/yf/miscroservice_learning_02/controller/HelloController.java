package top.yf.miscroservice_learning_02.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.yf.miscroservice_learning_02.service.HelloService;

@RestController
public class HelloController {
    @Resource
    private HelloService helloService;
    @GetMapping("/hello")
    public String getName(@RequestParam String name){
        return helloService.SayHello(name);
    }
}
