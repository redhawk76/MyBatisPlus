package xyz.redhawk.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xyz.redhawk.mybatisplus.entity.User;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
