package top.yangfan.productservice.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class ProductController {
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/product")
    public String createOrder(@RequestParam String username,String id,String product){
        String userServiceUrl="http://localhost:8081/user?username="+username;
        String userInfo = restTemplate.getForObject(userServiceUrl, String.class);
        String orderProductUrl="http://localhost:8082/order1?product="+product;
        String orderInfo = restTemplate.getForObject(orderProductUrl, String.class);
        return  "商品信息: " + id+userInfo+orderInfo;
    }
}
