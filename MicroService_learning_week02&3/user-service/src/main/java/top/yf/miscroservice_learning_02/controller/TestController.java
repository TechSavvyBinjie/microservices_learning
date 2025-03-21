package top.yf.miscroservice_learning_02.controller;


import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yf.miscroservice_learning_02.config.YfProperties;
import top.yf.miscroservice_learning_02.entity.TUser;
import top.yf.miscroservice_learning_02.result.Result;
import top.yf.miscroservice_learning_02.service.ITUserService;

@RefreshScope
@RestController
public class TestController {

    @Resource
    private YfProperties yfProperties;
    @Resource
    private ITUserService itUserService;

    @GetMapping("/test")
    public Result<TUser> get() {
        if (yfProperties.getServiceFlag()) {
            return Result.<TUser>builder().code("200").message("成功").data(itUserService.getById(1)).build();
        }
        else {
            return Result.<TUser>builder().code("503").message("正在维护中").build();
        }
        }
    }

