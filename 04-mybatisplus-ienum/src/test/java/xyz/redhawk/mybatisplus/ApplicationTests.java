package xyz.redhawk.mybatisplus;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.redhawk.mybatisplus.entitys.User;
import xyz.redhawk.mybatisplus.enums.UserIsDeleted;
import xyz.redhawk.mybatisplus.mapper.UserMapper;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ApplicationTests {
    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        User user = new User();
        user.setUsername("123");
        user.setPassword("321");
        user.setRoleId(1);
        user.setIsDeleted(UserIsDeleted.USER_NOT_DELETED);

        int insertNum = userMapper.insert(user);
        System.out.println("insertNum: " + insertNum);

        System.out.println(user);

        List<User> users = userMapper.selectList(null);
        System.out.println("users: " + users);
    }

}
