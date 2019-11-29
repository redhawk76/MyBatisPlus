package xyz.redhawk.mybatisplus.mapper;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import xyz.redhawk.mybatisplus.objects.entitys.User;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author redhawk
 * @since 2019-11-28
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

    //使用自定义SQL
    @Select("select * from user ${ew.customSqlSegment}")
    List<User> selectAll(@Param(Constants.WRAPPER)Wrapper<User> wrapper);

    //使用注解进行自定义SQL 查询
    @Select("select * from user ${ew.customSqlSegment}")
    List<User> selectAll2(@Param("ew")Wrapper<User> wrapper);

    //使用自定义SQL
    List<User> selectXmlAll(@Param("ew")Wrapper<User> wrapper);

    //自定义SQL, 并且分页查询
    List<User> selectUserPage(Page<User> page, @Param("ew") Wrapper<User> wrapper);

}
