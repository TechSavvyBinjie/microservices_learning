package top.yf.orderservice.Controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class OrderController {
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/order")
    public String createOrder(@RequestParam String username){
        String userServiceUrl="http://localhost:8081/user?username="+username;
        String userInfo = restTemplate.getForObject(userServiceUrl, String.class);
        return  userInfo;
    }
    @GetMapping("/order1")
    public String createOrder1(@RequestParam String product){
        return  "Product:"+product;
    }
}
