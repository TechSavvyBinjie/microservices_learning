package top.yf.requestservice.openfeign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import top.yf.requestservice.entity.TUser;
import top.yf.requestservice.Result.Result;

@Component
@Slf4j
public class UserServiceFallBackFactory implements FallbackFactory<HelloService> {
    @Override
    public HelloService create(Throwable cause) {
        log.error("用户服务调用异常：", cause);
        return new HelloService() {
            @Override
            public String h1(String name) {
                return null;
            }

            @Override
            public TUser h2(Long id) {
                // 降级用户
                TUser user = new TUser();
                user.setId(-1);
                user.setUserName("异常的用户名");
                user.setAvatarUrl("https://oss.hangzhou.com/1.jpg");
                return user;
            }

            @Override
            public Result<TUser> h3() {
                return null;
            }

        };
    }
}
