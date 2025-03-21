package top.yf.miscroservice_learning_02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import top.yf.miscroservice_learning_02.config.YfProperties;

@SpringBootApplication
@EnableConfigurationProperties({YfProperties.class})
public class MiscroServiceLearning02Application {

    public static void main(String[] args) {
        SpringApplication.run(MiscroServiceLearning02Application.class, args);
    }

}
