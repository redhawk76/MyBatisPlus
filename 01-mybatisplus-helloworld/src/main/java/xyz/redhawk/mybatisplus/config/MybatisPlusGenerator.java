package xyz.redhawk.mybatisplus.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description： mybatisPlus代码生成器基础类
 * @author: liping
 * @Date: 2019/11/27 22:52
 */
public class MybatisPlusGenerator {
    public static void main(String[] args) {
        try {
            AutoGenerator generator = new AutoGenerator();

            // 设置全局设置类
            GlobalConfig globalConfig = new GlobalConfig();
            // 生成文件的输出目录, 默认值：D 盘根目录

            String canonicalPath = "D:\\privateGit\\MyBatisPlus\\01-mybatisplus-helloworld";
            globalConfig.setOutputDir(canonicalPath + "/src/main/java");
            // 是否覆盖已有文件
            globalConfig.setFileOverride(true);
            // 生成文件后, 是否打开输出目录
            globalConfig.setOpen(true);
            // 是否在xml中添加二级缓存配置
            globalConfig.setEnableCache(false);
            // 开发人员
            String authorName = "liping404";
            globalConfig.setAuthor(authorName);
            // 开启 Kotlin 模式
            globalConfig.setKotlin(false);
            // 开启 swagger2 模式
            globalConfig.setSwagger2(false);
            // 开启 ActiveRecord 模式 (活动记录)
            globalConfig.setActiveRecord(true);
            // 开启 BaseResultMap
            globalConfig.setBaseResultMap(true);
            // 开启 baseColumnList
            globalConfig.setBaseColumnList(true);
            // 时间类型对应策略, 默认值：TIME_PACK
            //  ONLY_DATE,
            //  SQL_PACK,
            //  TIME_PACK;
            globalConfig.setDateType(DateType.TIME_PACK);
            // 实体命名方式, 例如：%sEntity 生成 UserEntity
            globalConfig.setEntityName("");
            // mapper 命名方式, 例如：%sMapper 生成 UserMapper
            globalConfig.setMapperName("%sMapper");
            // Mapper xml 命名方式, 例如：%sMapper 生成 UserMapper.xml
            globalConfig.setXmlName("%sMapper");
            // service 命名方式, 例如：%sService 生成 UserService
            globalConfig.setServiceName("%sService");
            // service impl 命名方式, 例如：%sServiceImpl 生成 UserServiceImpl
            globalConfig.setServiceImplName("%sServiceImpl");
            // controller 命名方式, 例如：%sController 生成 UserController
            globalConfig.setControllerName("%sController");
            // 指定生成的主键的ID类型
            //  AUTO(0),
            //  NONE(1),
            //  INPUT(2),
            //  ID_WORKER(3),
            //  UUID(4),
            //  ID_WORKER_STR(5);
            globalConfig.setIdType(IdType.AUTO);

            generator.setGlobalConfig(globalConfig);

            // 数据源配置
            DataSourceConfig dataSourceConfig = new DataSourceConfig();
            /**
             * 数据库配置四要素
             */
            String driverName = "com.mysql.jdbc.Driver";
            dataSourceConfig.setDriverName(driverName);
            dataSourceConfig.setDbType(DbType.MYSQL);
            String url = "jdbc:mysql://127.0.0.1:3306/study?useSSL=false";
            dataSourceConfig.setUrl(url);
            String username = "root";
            dataSourceConfig.setUsername(username);
            String password = "root";
            dataSourceConfig.setPassword(password);
            generator.setDataSource(dataSourceConfig);

            // 生成的包名配置
            PackageConfig packageConfig = new PackageConfig();
            /**
             * 基本包名
             */
            String basePackage = "xyz.redhawk.mybatisplus";
            packageConfig.setParent(basePackage);
            packageConfig.setController("controller");
            packageConfig.setEntity("entity");
            packageConfig.setMapper("mapper");
            packageConfig.setService("service");
            packageConfig.setXml("mapper.xml");
            packageConfig.setServiceImpl("service");
            generator.setPackageInfo(packageConfig);

            // 注入配置，通过该配置，可注入自定义参数等操作以实现个性化操作(待完善)
            InjectionConfig injectionConfig = new InjectionConfig() {
                @Override
                public void initMap() {
                    Map<String, Object> map = new HashMap<String, Object>(1);
                    map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                    this.setMap(map);
                }
            };

            List<FileOutConfig> fileOutList = new ArrayList<FileOutConfig>();
            fileOutList.add(new FileOutConfig("/templates/mapper.xml.vm") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return canonicalPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
                }
            });
            injectionConfig.setFileOutConfigList(fileOutList);
            generator.setCfg(injectionConfig);

            // 数据库表配置，通过该配置，可指定需要生成哪些表或者排除哪些表
            StrategyConfig strategyConfig = new StrategyConfig();
            //数据库表映射到实体的命名策略
            strategyConfig.setNaming(NamingStrategy.underline_to_camel);
            // 需要包含的表名
            strategyConfig.setInclude("user");
            // 【实体】是否为构建者模型
            strategyConfig.setEntityBuilderModel(true);
            // 【实体】是否为lombok模型
            strategyConfig.setEntityLombokModel(true);
            // Boolean类型字段是否移除is前缀
            strategyConfig.setEntityBooleanColumnRemoveIsPrefix(false);
            // 生成 @RestController 控制器
            strategyConfig.setRestControllerStyle(false);
            // 是否生成实体时，生成字段注解
            strategyConfig.setEntityTableFieldAnnotationEnable(true);
            // 逻辑删除属性名称
            strategyConfig.setLogicDeleteFieldName("isDeleted");
            generator.setStrategy(strategyConfig);
            generator.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
