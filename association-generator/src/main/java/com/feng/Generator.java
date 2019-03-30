package com.feng;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * Created by rf on 2019/2/27.
 */
public class Generator {
    public static void main(String[] args) {
        //指定包名
        String packageName = "com.feng";
        //user -> UserService, 设置成true: user -> IUserService
        boolean serviceNameStartWithI = false;
        //指定生成的表名
        String[] tableNames = new String[]{"user", "user_role", "user_rank","passage","passage_type"};
        Generator generator = new Generator();
        generator.generateByTables(serviceNameStartWithI, packageName, tableNames);
    }


    /**
     * 根据表自动生成
     *
     * @param serviceNameStartWithI 默认为false
     * @param packageName           包名
     * @param tableNames            表名
     * @author Terry
     */
    private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        //配置数据源
        DataSourceConfig dataSourceConfig = getDataSourceConfig();
        // 策略配置
        StrategyConfig strategyConfig = getStrategyConfig(tableNames);
        //全局变量配置
        GlobalConfig globalConfig = getGlobalConfig(serviceNameStartWithI);
        //包名配置
        PackageConfig packageConfig = getPackageConfig(packageName);
        //自动生成
        atuoGenerator(dataSourceConfig, strategyConfig, globalConfig, packageConfig);
    }

    /**
     * 集成
     *
     * @param dataSourceConfig 配置数据源
     * @param strategyConfig   策略配置
     * @param config           全局变量配置
     * @param packageConfig    包名配置
     * @author Terry
     */
    private void atuoGenerator(DataSourceConfig dataSourceConfig, StrategyConfig strategyConfig, GlobalConfig config, PackageConfig packageConfig) {
        new AutoGenerator()
                .setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                .execute();
    }

    /**
     * 设置包名
     *
     * @param packageName 父路径包名
     * @return PackageConfig 包名配置
     * @author Terry
     */
    private PackageConfig getPackageConfig(String packageName) {
        return new PackageConfig()
                .setParent(packageName)
                .setXml("mapper")
                .setMapper("dao")
                .setController("controller")
                .setEntity("entity");
    }

    /**
     * 全局配置
     *
     * @param serviceNameStartWithI false
     * @return GlobalConfig
     * @author Terry
     */
    private GlobalConfig getGlobalConfig(boolean serviceNameStartWithI) {
        String save_projectName="association-generator";
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig
                .setBaseColumnList(true)
                .setBaseResultMap(true)
                .setActiveRecord(false)
                .setAuthor("rf")
                //设置输出路径
                .setOutputDir(getOutputDir(save_projectName))
                .setFileOverride(true);
        if (!serviceNameStartWithI) {
            //设置service名
            globalConfig.setServiceName("%sService");
        }
        return globalConfig;
    }

    /**
     * 返回项目路径
     *
     * @param projectName 项目名
     * @return 项目路径
     * @author Terry
     */
    private String getOutputDir(String projectName) {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        int index = path.indexOf(projectName);
        return path.substring(1, index) + projectName + "/src/main/java/";
    }

    /**
     * 策略配置
     *
     * @param tableNames 表名
     * @return StrategyConfig
     * @author Terry
     */
    private StrategyConfig getStrategyConfig(String... tableNames) {
        return new StrategyConfig()
                // 全局大写命名 ORACLE 注意
                .setCapitalMode(true)
                .setEntityLombokModel(false)
                // 表名、字段名、是否使用下划线命名（默认 false）
                .setDbColumnUnderline(true)
                //从数据库表到文件的命名策略
                .setNaming(NamingStrategy.underline_to_camel)
                //需要生成的的表名，多个表名传数组
                .setInclude(tableNames);
    }

    /**
     * 配置数据源
     *
     * @return 数据源配置 DataSourceConfig
     * @author Terry
     */
    private static DataSourceConfig getDataSourceConfig() {
        String dbUrl = "jdbc:mysql://localhost:3306/club?useUnicode=true&serverTimezone=UTC";
        return new DataSourceConfig().setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("123456")
                .setDriverName("com.mysql.jdbc.Driver");
    }

    /**
     * 根据表自动生成
     *
     * @param packageName 包名
     * @param tableNames  表名
     * @author Terry
     */
    @SuppressWarnings("unused")
    private void generateByTables(String packageName, String... tableNames) {
        generateByTables(true, packageName, tableNames);
    }


}

