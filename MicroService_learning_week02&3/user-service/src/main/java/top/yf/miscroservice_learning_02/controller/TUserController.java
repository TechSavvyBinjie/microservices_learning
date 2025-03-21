package top.yf.miscroservice_learning_02.controller;


import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.yf.miscroservice_learning_02.entity.TUser;
import top.yf.miscroservice_learning_02.service.ITUserService;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author author
 * @since 2025-02-28
 */
@Slf4j
@RestController
@RequestMapping("/t-user")
public class TUserController {
   @Resource
    private ITUserService itUserService;

    @GetMapping("/{id}")
    public TUser getClazzWithTeacher(@PathVariable Long id) {
        log.info("该服务被调用1111111111111111111111111111111");
        return itUserService.getById(id);

    }

}
