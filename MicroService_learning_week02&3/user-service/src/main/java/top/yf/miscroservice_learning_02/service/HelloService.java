package top.yf.miscroservice_learning_02.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String getName(){
        return "hello";
    }
    public String SayHello(String name){
        return "hello"+name;
    }
}
