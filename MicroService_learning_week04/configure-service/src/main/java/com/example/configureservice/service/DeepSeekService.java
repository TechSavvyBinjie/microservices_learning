package com.example.configureservice.service;

import com.example.configureservice.DeepSeek.DeepSeekRequest;
import com.example.configureservice.DeepSeek.DeepSeekResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Service
public class DeepSeekService {

    @Value("${deepseek.api.key}")
    private String apiKey;

    @Value("${deepseek.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public String callDeepSeek(String userMessage) {
        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Bearer " + apiKey);

        // 构建请求体
        DeepSeekRequest request = new DeepSeekRequest();
        request.setModel("deepseek-chat");
        request.setMessages(List.of(new DeepSeekRequest.Message("user", userMessage)));

        // 发送请求
        HttpEntity<DeepSeekRequest> entity = new HttpEntity<>(request, headers);
        ResponseEntity<DeepSeekResponse> response = restTemplate.exchange(
                apiUrl, HttpMethod.POST, entity, DeepSeekResponse.class);

        // 解析响应
        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return response.getBody().getChoices().get(0).getMessage().getContent();
        } else {
            throw new RuntimeException("Failed to call DeepSeek API: " + response.getStatusCode());
        }
    }
}
