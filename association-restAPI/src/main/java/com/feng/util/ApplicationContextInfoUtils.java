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
        String visitUrl = "http://localhost:"+port+contextPath;
        logger.info("欢迎使用club前台系统，本地访问url：{}",visitUrl);
        logger.info("后端swagger api接口文档url：{}",visitUrl+"/api/swagger");

    }
}
