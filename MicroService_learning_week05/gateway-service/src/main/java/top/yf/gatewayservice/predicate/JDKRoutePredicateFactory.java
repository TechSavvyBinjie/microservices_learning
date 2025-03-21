package top.yf.gatewayservice.predicate;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
@Component
public class JDKRoutePredicateFactory extends AbstractRoutePredicateFactory<JDKRoutePredicateFactory.Config> {

    public static final String VERSION = "version";

    public JDKRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList(VERSION);
    }



    @Data
    @AllArgsConstructor
    public static class Config {
        @NotNull
        private String version;
    }
    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                String version = System.getProperty("java.version");
                return StringUtils.isNotBlank(version) & version.startsWith(config.getVersion());
            }

            @Override
            public Object getConfig() {
                return config;
            }

            @Override
            public String toString() {
                return String.format("JDK Version: %s", config.getVersion());
            }
        };
    }
}