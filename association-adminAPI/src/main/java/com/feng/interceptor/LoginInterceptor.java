package com.feng.interceptor;

import com.feng.constants.AppConstant;
import com.feng.entity.User;
import com.feng.enums.ErroEnum;
import com.feng.exception.AuthenticationFailException;
import com.feng.util.CookieUtil;
import com.feng.util.RedisOption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by rf on 2019/4/23.
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisOption redisOption;
    @Autowired
    private AppConstant appConstant;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = (String) request.getParameter("token");
        if(token==null){
            token = getUserCookie(request);
        }

        if (!StringUtils.isEmpty(token)) {
            boolean exist = redisOption.hasKey(token);
            if (exist) {
                return true;
            }
        }
//        return true;
        throw new AuthenticationFailException(ErroEnum.USER_NOT_LOGIN);
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

    /**
     * 客户端保存用户登录信息
     * @param response
     * @param token
     */
    private void saveUserCookie(HttpServletResponse response, String token) {
        CookieUtil.writeCookie(response, "userToken", token);
    }

    /**
     * 客户端保存获取登录信息
     * @param request
     * @return
     */
    private String getUserCookie(HttpServletRequest request) {
       return CookieUtil.getCookie(request, "token");
    }
}
