package com.feng.interceptor;

import com.alibaba.fastjson.JSON;
import com.feng.entity.ResponseResult;
import com.feng.enums.ErrorEnum;
import com.feng.exception.AuthenticationFailException;
import com.feng.service.UserSessionService;
import com.feng.util.ResponseResultUtil;
import com.feng.util.UserTokenUtils;
import com.mysql.cj.jdbc.util.ResultSetUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Created by rf on 2019/4/23.
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private UserSessionService userSessionService;
    @Value("${system.openDevEnv}")
    private boolean isOpenTestDev = false;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = UserTokenUtils.getUserToken(request);
        String url = request.getRequestURI();
        if (StringUtils.isEmpty(token)) {
            //如果开启测试环境，所有请求放行
            if (isOpenTestDev) {
                log.info("请求url：{}，token不存在。由于开启测试环境，不校验token是否为空、有效", url);
                return true;
            }
            renderJsonError(response, "没有授权,请先登录");
            return false;
        }


        //判断用户token是否有效
        boolean exist = userSessionService.isUserTokenExist(token);
        if (exist) {
            log.info("更新token在redis中会话时间");
            userSessionService.updateUserSession(token);
            return true;
        } else {
            //如果开启测试环境，所有请求放行
            if (isOpenTestDev) {
                log.info("请求url：{}，token无效，由于开启测试环境，不校验token有效性", url);
                return true;
            }

        }
        renderJsonError(response, "没有授权,请先登录");
        return false;

    }


    private void renderJsonError(HttpServletResponse response, String msg) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        ResponseResult responseResult = ResponseResultUtil.renderError(ErrorEnum.UNAUTHORIZED.setMsg(msg));
        String errorJson = JSON.toJSONString(responseResult);
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
            printWriter.print(errorJson);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null)
                printWriter.close();
        }


    }

}
