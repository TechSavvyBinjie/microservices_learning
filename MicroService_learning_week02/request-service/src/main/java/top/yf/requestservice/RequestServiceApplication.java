package top.yf.requestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import top.yf.requestservice.config.RandomLoadBalancerConfig;

@EnableFeignClients(basePackages = {"top.yf.requestservice.openfeign"})
@SpringBootApplication
@LoadBalancerClient(name="Hello-service",configuration= RandomLoadBalancerConfig.class)
public class RequestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RequestServiceApplication.class, args);
    }

}
