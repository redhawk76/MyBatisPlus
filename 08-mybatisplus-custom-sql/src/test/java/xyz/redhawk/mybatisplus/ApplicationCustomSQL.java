package xyz.redhawk.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.redhawk.mybatisplus.mapper.UserMapper;
import xyz.redhawk.mybatisplus.objects.entitys.User;

import java.util.List;

@SpringBootTest
class ApplicationCustomSQL {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    //自定义sql
      @Test
    public void selectLambda20() {
        LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery();

    //  lambdaQuery.likeRight(User::getName, "王").and(lqw -> lqw.lt(User::getAge, 40).or().isNotNull(User::getEmail));
    List<User> users = userMapper.selectXmlAll(lambdaQuery);



    //sql 拼接
        users.forEach(System.out::println);
}

    //sql 拼接 , apply方法
    @Test
    public void selectByWrapper4() {
        //创建构造器的第一种方式
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.apply("date_format(create_time,'%Y-%m-%d')={0}", "2019-08-31")
                .inSql("manager_id", "select id from user where name like '%大%'");
        List<User> users = userMapper.selectList(queryWrapper);

        users.forEach(System.out::println);
    }


}
