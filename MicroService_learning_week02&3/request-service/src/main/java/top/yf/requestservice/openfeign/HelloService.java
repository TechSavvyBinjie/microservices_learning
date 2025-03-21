package top.yf.requestservice.openfeign;

import lombok.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import top.yf.requestservice.Result.Result;
import top.yf.requestservice.entity.TUser;

@FeignClient(value="user-service",fallbackFactory = UserServiceFallBackFactory.class)
public interface HelloService {
    @GetMapping(value = "/hello")
    String h1(@RequestParam String name);
    @GetMapping(value = "/t-user/{id}")
    TUser h2(@PathVariable Long id);
    @GetMapping(value = "/test")
    Result<TUser> h3();
 }
