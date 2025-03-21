package top.yf.requestservice.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SentineConfig {
    @Bean
    public BlockExceptionHandler sentinelExceptionHandle(){
        return new SentinelException();
    }
    @Bean
    public RequestOriginParser sentinelOriginHandle(){
        return new SentinelRequestOriginParser();
    }
}
