package com.example.configureservice.controller;


import com.example.configureservice.Util.OssUtil;
import com.example.configureservice.entity.TUser;
import com.example.configureservice.service.DeepSeekService;
import com.example.configureservice.service.ITUserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author author
 * @since 2025-03-07
 */
@RestController
@RequestMapping("/t-user")
public class TUserController {
    @Resource
    private ITUserService itUserService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private RedisTemplate<String, TUser> redisTemplate;
    @GetMapping("/database")
    public String get1(){
        return itUserService.getById(1).toString();
    }
    @GetMapping("/redis")
    public String get2(){
        stringRedisTemplate.opsForValue().set("hello","world",60, TimeUnit.SECONDS);
        return "redis测试";
    }
    @GetMapping("/oss")
    public String get3(){
        stringRedisTemplate.opsForValue().set("hello","world",60, TimeUnit.SECONDS);
        return "redis测试";
    }
    @Resource
    private OssUtil ossutil;

    /**
     * 上传文件接口
     *
     * @param file 文件
     * @return 返回文件的URL
     */
    @PostMapping("/upload")
    public Map<String, Object> uploadFile(@RequestParam("file") MultipartFile file) {
        String fileUrl = ossutil.uploadFile(file);
        Map<String, Object> response = new HashMap<>();
        response.put("fileUrl", fileUrl);
        return response;
    }
    @Autowired
    private DeepSeekService deepSeekService;

    @PostMapping("/chat")
    public String chat(@RequestParam String message) {
        return deepSeekService.callDeepSeek(message);
    }
}
