package com.feng.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

public class ApplicationContextInfoUtils {
    private static Logger logger = LoggerFactory.getLogger("");
    public static void printSystemInfo(ApplicationContext applicationContext) {
        Environment environment = applicationContext.getEnvironment();
        String port = environment.getProperty("server.port");
        String contextPath = environment.getProperty("server.servlet.context-path");
        String ip = "localhost";
        String indexUrl = "http://"+ip+":"+port+contextPath;
        logger.info("欢迎访问club后台系统，系统首页url：{}",indexUrl);
        logger.info("后端swagger接口文档url：{}",indexUrl+"/swagger-ui.html");
        logger.info("后端 druid 监控中心url：{},用户名 admin，密码 admin",indexUrl+"/druid");

    }
}
