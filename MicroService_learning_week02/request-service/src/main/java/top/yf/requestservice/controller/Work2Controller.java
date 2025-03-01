package top.yf.requestservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
@RestController
public class Work2Controller {
    private  final String SERVICE_URL="https://www.wanandroid.com/article/list/0/json";
    private  final WebClient webClient=WebClient.builder()
            .baseUrl(SERVICE_URL)
            .build();
    @GetMapping("/test2")
    public Mono<String> webClientTest(@RequestParam int a){
        Mono<String> mono=webClient
                .get()
                .uri("")
                .retrieve()
                .bodyToMono(String.class);
        mono.subscribe(System.out::println);
        return mono;
    }
}
