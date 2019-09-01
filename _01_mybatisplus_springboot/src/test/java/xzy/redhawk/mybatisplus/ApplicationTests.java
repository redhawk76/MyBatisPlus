package xzy.redhawk.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.Update;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.redhawk.mybatisplus.Application;
import xyz.redhawk.mybatisplus.domain.User;
import xyz.redhawk.mybatisplus.mapper.UserMapper;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {

    //   private final static Logger logger = LoggerFactory.getLogger(ApplicationTests.class);

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {

        //使用selectList方法传递null,默认查询所有
        List<User> users = userMapper.selectList(null);
        Assert.assertEquals(5, users.size());
        users.forEach(System.out::println);
    }

    //新增
    @Test
    public void insert() {
        User user = new User();

        user.setName("redhawk");
        user.setAge(44);
        user.setManagerId(1087982257332887553L);
        user.setCreateTime(LocalDateTime.now());
        int rows = userMapper.insert(user);
        System.out.println("影响记录数" + rows);

    }

    //删除
    @Test
    public void delete() {
        int flag = 1;
        int i = userMapper.deleteById("1167697446973796353");
        String result = (flag == i) ? "删除成功" : "删除失败";
        System.out.println(result);
    }

    //修改
    @Test
    public void update() {

    }

    //查询

    //根据id查询
    @Test
    public void select() {
        User user = userMapper.selectById("1094590409767661570");
        System.out.println(user);
    }

    //多个id进行查询
    @Test
    public void selectIds() {
        List<Long> ids = Arrays.asList(1087982257332887553L, 1088248166370832385L, 1094590409767661570L);
        List<User> users = userMapper.selectBatchIds(ids);
        users.forEach(System.out::println);
    }

    //根据某个字段查询
    @Test
    public void selectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("age", 44);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    //构造器查询
    //需求 : 名字中包含雨并且年龄小于40 namelike '%雨%' and age < 40
    @Test
    public void selectByWrapper() {
        //创建构造器的第一种方式
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        //创建条件构造器的第二种方式 Wrappers工具类创建
        QueryWrapper<User> query = Wrappers.<User>query();

        query.like("name", "e").lt("age", 100);
        List<User> users = userMapper.selectList(query);
        users.forEach(System.out::println);
    }


    //需求 : 名字中包含雨并且年龄大于等于20 且小于等于40 并且email不能为空
    @Test
    public void selectByWrapper2() {
        //创建构造器的第一种方式
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        //创建条件构造器的第二种方式 Wrappers工具类创建
        QueryWrapper<User> query = Wrappers.<User>query();

        query.like("name", "re").between("age", 35, 100).isNotNull("email");
        List<User> users = userMapper.selectList(query);
        users.forEach(System.out::println);
    }


    //需求 : 名字中包含王,或者年龄大于等于25,
    //  然后按照年龄降序排列,
    // 如果两个人的年级相同 就 按照id升序排列
    @Test
    public void selectByWrapper3() {
        //创建构造器的第一种方式
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        //创建条件构造器的第二种方式 Wrappers工具类创建
        QueryWrapper<User> query = Wrappers.<User>query();

        query.likeRight("name", "王").or().ge("age", 35).orderByDesc("age").orderByAsc("id");
        List<User> users = userMapper.selectList(query);
        users.forEach(System.out::println);
    }


    //需求 : 创建日期为2019年2月14日并且指数上级为名字姓王

    @Test
    public void selectByWrapper4() {
        //创建构造器的第一种方式
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.apply("date_format(create_time,'%Y-%m-%d')={0}", "2019-08-31")
                .inSql("manager_id", "select id from user where name like '%大%'");
        List<User> users = userMapper.selectList(queryWrapper);

        users.forEach(System.out::println);
    }


    //需求 : 名字为王姓, 并且年龄小于40或者邮箱不为空

    @Test
    public void selectByWrapper5() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.likeRight("name", "王").and(wq -> wq.lt("age", 40).or().isNotNull("email"));
        List<User> users = userMapper.selectList(queryWrapper);

        users.forEach(System.out::println);
    }

    //需求 : 名字为王姓, 并且年龄小于40或者邮箱不为空
    @Test
    public void selectByWrapper6() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.likeRight("name", "王").and(wq -> wq.lt("age", 40).or().isNotNull("email"));
        List<User> users = userMapper.selectList(queryWrapper);

        users.forEach(System.out::println);
    }

    //#查询指定字段
    @Test
    public void selectByWrapperSupper() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.select("id", "name");
        List<User> users = userMapper.selectList(queryWrapper);

        users.forEach(System.out::println);
    }

    //排除字段
    @Test
    public void selectByWrapperSupper2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.select(User.class, info -> !info.getColumn().equals("create_time") && !info.getColumn().equals("manager_id"));
        List<User> users = userMapper.selectList(queryWrapper);

        users.forEach(System.out::println);
    }


    //查询指定字段数量
    @Test
    public void selectByWrapperMaps() {


        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

/*
如果我们想查询一个对象里面的两个字段,
要是使用selectList查询的话;
可以实现,但是其他的字段都是null ,这样自己就不好看了
我们可以使用selectMaps方法来查询, 这样查询出来的字段就真正的返回两个了;

 */
        queryWrapper.select("id", "name");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);

        maps.forEach(System.out::println);
    }

    //需求 , 按照直属上级分组, 查询每组的平均年龄, 最大年龄,最小年龄;
    /*
    并且只取年龄总和小于500的组.
    
     */

    //自定义sql

    @Test
    public void selectLambda20() {

        LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery();
        //  lambdaQuery.likeRight(User::getName, "王").and(lqw -> lqw.lt(User::getAge, 40).or().isNotNull(User::getEmail));
        List<User> users = userMapper.selectAllXml(lambdaQuery);
        users.forEach(System.out::println);
    }


    //分页查询
    @Test
    public void selectPage() {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = Wrappers.<User>lambdaQuery();
        // 第一个参数 , 第二个参数
        Page<User> userPage = new Page<>(1, 2);

        IPage<User> userIPage = userMapper.selectPage(userPage, userLambdaQueryWrapper);

        System.out.println("总页数:" + userIPage.getPages());
        System.out.println("总记录数:" + userIPage.getTotal());
        List<User> records = userIPage.getRecords();
        records.forEach(System.out::println);

    }


    //分页查询
    @Test
    public void selectMapPage() {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = Wrappers.<User>lambdaQuery();
        // 第一个参数 , 第二个参数
        Page<User> userPage = new Page<>(1, 2);

        IPage<Map<String, Object>> mapIPage = userMapper.selectMapsPage(userPage, userLambdaQueryWrapper);

        System.out.println("总页数:" + mapIPage.getPages());
        System.out.println("总记录数:" + mapIPage.getTotal());
        List<Map<String, Object>> records = mapIPage.getRecords();
        records.forEach(System.out::println);

    }


    //分页查询
    @Test
    public void selectUserPage() {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = Wrappers.<User>lambdaQuery();
        // 第一个参数 , 第二个参数
        Page<User> userPage = new Page<>(1, 2);

        IPage<User> userIPage = userMapper.selectUserPage(userPage, userLambdaQueryWrapper);

        System.out.println("总页数:" + userIPage.getPages());
        System.out.println("总记录数:" + userIPage.getTotal());

    }

    //更新方法 根据id更新
    @Test
    public void updateById() {
        User user = new User();
        user.setId(1167775750930067458L);
        user.setName("红鹰");
        user.setAge(26);
        user.setEmail("972419185@qq.com");
        int i = userMapper.updateById(user);
}

    //条件构造器作为参数更新
    @Test
    public void updateWrapper(){
        //创建一个更新构造器
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<User>();
        //修改一个名字叫redhawk的记录
        updateWrapper.eq("name","redhawk").eq("age",44);
        User user = new User();
        user.setEmail("redhawk26@qq.com");
        user.setAge(27);
        int update = userMapper.update(user, updateWrapper);
    }


    //条件构造器Lambda表达式方法更新
    @Test
    public void updateWrapperLambda(){
        LambdaQueryWrapper<User> userLambdaQueryWrapper = Wrappers.<User>lambdaQuery();

        userLambdaQueryWrapper.eq(User::getName,"redhawk").eq(User::getAge,27);
        User user = new User();
        user.setName("redhawkLambda");
        user.setEmail("redhawk26@qq.com");
        user.setAge(25);
        int update = userMapper.update(user, userLambdaQueryWrapper);

    }


    //条件构造器set方法更新
    @Test
    public void updateWrapperSet(){

    }


    //根据id删除
    @Test
    public void deleteById(){
        //返回的是一个影响记录数
        int i = userMapper.deleteById(1167775750930067458L);
        System.out.println("删除条数:"+i);
    }

    //根据字段删除
    public void deleteMap(){
        Map<String,Object> map = new HashMap();
        map.put("name","redhawkLambda");
        map.put("age","25");
        int i = userMapper.deleteByMap(map);
        System.out.println("删除条数:"+i);
    }


    //条件构造器删除
    @Test
    public void deleteWrapper(){


    }
    //批量删除
    public void deleteByIds(){

    }

}
