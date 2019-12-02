package xyz.redhaw.mybatisplus;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.redhaw.mybatisplus.entity.User;
import xyz.redhaw.mybatisplus.mapper.UserMapper;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ApplicationTests {
    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
//        for (int i = 0; i < 10; i++) {
//            User user = new User();
//            user.setIsDeleted(0);
//            user.setPassword("123");
//            user.setUsername("123");
//            user.setRoleId(1);
//
//            userMapper.insert(user);
//        }




        int i = userMapper.deleteById(6);

        System.out.println("删除个数: " + i);
//
//        User user = userMapper.selectById(4);
//        System.out.println("删除后数据: " + user);
//
        List<User> users = userMapper.selectList(null);

        System.out.println(users);

    }

}
