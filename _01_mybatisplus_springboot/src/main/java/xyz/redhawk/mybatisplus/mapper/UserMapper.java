package xyz.redhawk.mybatisplus.mapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import xyz.redhawk.mybatisplus.domain.User;
import java.util.List;

/**
 * @author RedHawk
 * @create 2019-09-01 23:56
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user ${ew.customSqlSegment}")
    List<User> selectAll(@Param(Constants.WRAPPER)Wrapper<User> wrapper);

    @Select("select * from user ${ew.customSqlSegment}")
    List<User> selectAll2(@Param("ew")Wrapper<User> wrapper);


    List<User> selectAllXml(@Param("ew")Wrapper<User> wrapper);


    //自定义SQL, 并且分页查询
    IPage<User> selectUserPage(Page<User> page, @Param("ew")Wrapper<User> wrapper);

}
