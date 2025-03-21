package top.yf.requestservice.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.yf.requestservice.entity.ShareVO;
import top.yf.requestservice.entity.TUser;
import top.yf.requestservice.openfeign.HelloService;
import top.yf.requestservice.service.ITShareService;

/**
 * <p>
 * 分享表 前端控制器
 * </p>
 *
 * @author author
 * @since 2025-02-28
 */
@RestController
@RequestMapping("/t-share")
public class TShareController {
    @Resource
    private ITShareService itShareService;
@Resource
private HelloService helloService;
    @GetMapping("/{id}")
    @SentinelResource(value = "/{id}")
    public ShareVO getClazzWithTeacher(@PathVariable Long id) {
        TUser tUser=helloService.h2(id);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ShareVO shareVO=new ShareVO();
        shareVO.settShare( itShareService.getById(id));
        shareVO.setUserName(tUser.getUserName());
        shareVO.setId(tUser.getId());
        shareVO.setAvatarUrl(tUser.getAvatarUrl());
        return shareVO;
    }
    @GetMapping("share")
    public TUser getClazzWithTeacher() {
        return helloService.h3().getData();
    }
}
