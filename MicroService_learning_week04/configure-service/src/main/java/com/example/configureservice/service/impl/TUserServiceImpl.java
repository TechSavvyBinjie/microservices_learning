package com.example.configureservice.service.impl;


import com.example.configureservice.entity.TUser;
import com.example.configureservice.mapper.TUserMapper;
import com.example.configureservice.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author author
 * @since 2025-03-07
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}
