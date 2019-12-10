package xyz.redhawk.mybatisplus.service;

import xyz.redhawk.mybatisplus.entity.User;
import xyz.redhawk.mybatisplus.mapper.UserMapper;
import xyz.redhawk.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liping404
 * @since 2019-12-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
