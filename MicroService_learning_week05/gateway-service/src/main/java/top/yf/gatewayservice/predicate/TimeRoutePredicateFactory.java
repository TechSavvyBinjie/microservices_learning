package top.yf.gatewayservice.predicate;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Component
public class TimeRoutePredicateFactory extends AbstractRoutePredicateFactory<TimeRoutePredicateFactory.Config> {
    public TimeRoutePredicateFactory() {
        super(TimeRoutePredicateFactory.Config.class);
    }

    //用于从配置文件中获取参数值赋值到配置类中的属性上
    @Override
    public List<String> shortcutFieldOrder() {
        //这里的顺序要跟配置文件中的参数顺序一致
        return Arrays.asList("startTime","endTime");
    }

    //断言
    @Override
    public Predicate<ServerWebExchange> apply(TimeRoutePredicateFactory.Config
                                                      config) {
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                //从serverWebExchange获取传入的参数
                LocalTime time = LocalTime.now();
                LocalTime start = LocalTime.parse(config.getStartTime());
                LocalTime end = LocalTime.parse(config.getEndTime());
                    return  start.isBefore(time) && end.isAfter(time);
            }
        };
    }
    //配置类,用于接收配置文件中的对应参数
    @Data
    @NoArgsConstructor
    public static class Config {
        private String startTime;//开始时间
        private String endTime;//结束时间
    }
}