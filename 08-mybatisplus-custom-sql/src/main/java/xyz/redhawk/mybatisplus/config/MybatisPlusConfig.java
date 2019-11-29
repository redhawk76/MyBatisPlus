package xyz.redhawk.mybatisplus.config;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <Description> <br>
 *
 * @author redhawk<br>
 * @taskId:   <br>
 * @version 1.0<br>
 * @createDate 2019/09/02 0:55 <br>
 * @see xyz.redhawk.mybatisplus.config <br>
 */
@Configuration
public class MybatisPlusConfig {


    @Bean
    public PaginationInterceptor paginationInterceptor(){
        //设置分页插件
        PaginationInterceptor PaginationInterceptor = new PaginationInterceptor();

        //设置方言
        PaginationInterceptor.setDialectType("mysql");
        return PaginationInterceptor;
    }
}
