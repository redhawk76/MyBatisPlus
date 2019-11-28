package xyz.redhawk.mybatisplus.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.io.IOException;
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
    /**
     * 项目路径
     */
    private static String canonicalPath = "C:\\C\\studyWorkspace\\MyBatisPlusStudy\\01-mybatisplus-helloworld";

    /**
     * 基本包名
     */
    private static String basePackage = "xyz.redhawk.mybatisplus";

    /**
     * 作者
     */
    private static String authorName = "liping404";


    private static String[] tables = {"user"};
    /**
     * table前缀
     */
//    private static String[] prefix = {"r_basic", "t_basic", "t_matrix", "t_node"};

    /**
     * 数据库类型
     */
    private static DbType dbType = DbType.MYSQL;

    /**
     * 数据库配置四要素
     */
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1:3306/study?useSSL=false";
    private static String username = "root";
    private static String password = "root";

    public static void main(String[] args) {
        try {
            AutoGenerator generator = new AutoGenerator();

            GlobalConfig globalConfig = new GlobalConfig();
            globalConfig.setOutputDir(canonicalPath + "/src/main/java");
            globalConfig.setFileOverride(true);
            globalConfig.setActiveRecord(true);
            globalConfig.setEnableCache(false);
            globalConfig.setBaseResultMap(true);
            globalConfig.setBaseColumnList(true);
            globalConfig.setOpen(true);
            globalConfig.setAuthor(authorName);
            globalConfig.setMapperName("%sMapper");
            globalConfig.setXmlName("%sMapper");
//            globalConfig.setServiceName("%sService");
            globalConfig.setServiceImplName("%sService");
//            globalConfig.setControllerName("%sController");
            generator.setGlobalConfig(globalConfig);

            // 数据源配置
            DataSourceConfig dataSourceConfig = new DataSourceConfig();
            dataSourceConfig.setDriverName(driverName);
            dataSourceConfig.setDbType(dbType);
            dataSourceConfig.setUrl(url);
            dataSourceConfig.setUsername(username);
            dataSourceConfig.setPassword(password);
            generator.setDataSource(dataSourceConfig);

            PackageConfig packageConfig = new PackageConfig();
            packageConfig.setParent(basePackage);
            packageConfig.setController("controller");
            packageConfig.setEntity("entity");
            packageConfig.setMapper("mapper");
            packageConfig.setService("service");
            packageConfig.setXml("mapper.xml");
//            packageConfig.setServiceImpl("service");
            generator.setPackageInfo(packageConfig);

            InjectionConfig injectionConfig = new InjectionConfig() {
                @Override
                public void initMap() {
                    Map<String, Object> map = new HashMap<String, Object>();
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

            StrategyConfig strategyConfig = new StrategyConfig();
//        strategyConfig.setTablePrefix(prefix);

            //数据库表映射到实体的命名策略
            strategyConfig.setNaming(NamingStrategy.underline_to_camel);
            // 包含的表
            strategyConfig.setInclude(tables);
            strategyConfig.setEntityBuilderModel(true);
            generator.setStrategy(strategyConfig);
            generator.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
