package top.yf.miscroservice_learning_02.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "yf")
@Component
public class YfProperties {
    private String username;
    private String job;
    private  Boolean serviceFlag;
}
