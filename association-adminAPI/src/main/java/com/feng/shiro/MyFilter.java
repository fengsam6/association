package com.feng.shiro;

import com.feng.enums.ErroEnum;
import com.feng.util.ResponseResultUtil;
import org.apache.shiro.web.filter.authc.UserFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

import com.alibaba.fastjson.JSON;

/**
 * Created by rf on 2019/6/3.
 */
public class MyFilter extends UserFilter {
    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().print(JSON.toJSON(ResponseResultUtil.renderError(ErroEnum.USER_NOT_LOGIN)));
    }
}
