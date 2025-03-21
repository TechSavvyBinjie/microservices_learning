package top.yf.miscroservice_learning_02.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.yf.miscroservice_learning_02.entity.TUser;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author author
 * @since 2025-02-28
 */
@Mapper
public interface TUserMapper extends BaseMapper<TUser> {

}
