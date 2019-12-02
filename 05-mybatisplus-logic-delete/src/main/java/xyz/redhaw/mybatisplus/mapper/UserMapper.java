package xyz.redhaw.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import xyz.redhaw.mybatisplus.entity.User;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
