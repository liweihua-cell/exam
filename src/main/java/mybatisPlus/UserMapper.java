package mybatisPlus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liweihua
 * @classname UserMapper
 * @description TODO
 * @date 2023/6/19 8:53
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    @Select("select a.*,b.name as class_name from user a,class b,user_class c where a.id=c.user_id and b.id=c.class_id")
    List<UserVO> getAllUsers();

    @Select("select a.*,c.name as class_name from user a left join user_class b on a.id = b.user_id left join class c on " +
            "b.class_id = c.id" + "$(ew.customSqlSegment)")
    IPage<UserVO> getUserByPage(IPage<UserVO> page, @Param(Constants.WRAPPER) QueryWrapper queryWrapper);
}
