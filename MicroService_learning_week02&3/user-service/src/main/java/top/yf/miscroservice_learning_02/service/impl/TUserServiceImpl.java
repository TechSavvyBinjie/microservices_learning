package top.yf.miscroservice_learning_02.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.yf.miscroservice_learning_02.entity.TUser;
import top.yf.miscroservice_learning_02.mapper.TUserMapper;
import top.yf.miscroservice_learning_02.service.ITUserService;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author author
 * @since 2025-02-28
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}
