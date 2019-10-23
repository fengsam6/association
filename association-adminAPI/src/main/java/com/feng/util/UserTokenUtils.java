package com.feng.util;

import javax.servlet.http.HttpServletRequest;

public class UserTokenUtils {
    public static String getUserToken(HttpServletRequest request){
        String token = request.getParameter("token");
        if(token==null){
            token = CookieUtil.getCookie(request, "token");
        }
        return token;
    }
}
