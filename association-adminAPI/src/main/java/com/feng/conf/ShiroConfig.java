package com.feng.conf;

import com.feng.shiro.MyFilter;
import com.feng.shiro.UserRealm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by rf on 2019/6/3.
 */
@Configuration
public class ShiroConfig {
    @Bean(name = "sessionManager")
    public SessionManager sessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        //设置session过期时间为1小时(单位：毫秒)，默认为30分钟
        sessionManager.setGlobalSessionTimeout(60 * 60 * 1000 * 24 * 7);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }

    @Bean(name = "securityManager")
    public SecurityManager securityManager(UserRealm userRealm, SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //Realm 主要是从realm中获取相应的身份信息
        securityManager.setRealm(userRealm);
        securityManager.setSessionManager(sessionManager);

        return securityManager;
    }

    //传统方式是使用web.xml配置的。在shiro中使用@Bean注解方式实现过滤器。
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        Map<String,Filter> filters = shiroFilter.getFilters();
        filters.put("authc", new MyFilter());
        shiroFilter.setFilters(filters);
        //shiroFilter.setLoginUrl("/login.html");//默认访问的首页面
        //shiroFilter.setSuccessUrl("/index.html");
        //shiroFilter.setUnauthorizedUrl("/");

        //anon代表是匿名访问方式，比如index.html是匿名访问的即不区分用户、谁都可以访问。
        Map<String, String> filterMap = new LinkedHashMap<>();

        filterMap.put("/users/login", "anon");
        filterMap.put("/users/getKaptcha", "anon");

        //authc代表是必须认证访问的。/**代表是除上面配置以外的其它资源。
        filterMap.put("/**", "authc");
        shiroFilter.setFilterChainDefinitionMap(filterMap);
        return shiroFilter;
    }

}
