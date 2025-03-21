package top.yf.requestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import top.yf.requestservice.config.RandomLoadBalancerConfig;
import top.yf.requestservice.handler.SentineConfig;

@EnableFeignClients(basePackages = {"top.yf.requestservice.openfeign"})
@SpringBootApplication
@LoadBalancerClient(name="Hello-service",configuration= RandomLoadBalancerConfig.class)
@Import({SentineConfig.class})
public class RequestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RequestServiceApplication.class, args);
    }

}
