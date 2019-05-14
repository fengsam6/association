package com.feng.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by rf on 2019/5/4.
 */
public class CookieUtil {
    public static String getCookie(HttpServletRequest request, String cookieName){

        Cookie[] cookies =  request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(cookieName)){
                    return cookie.getValue();
                }
            }
        }

        return null;
    }

    public static void writeCookie(HttpServletResponse response, String cookieName,int time, String value){
        Cookie cookie = new Cookie(cookieName,value);
        cookie.setPath("/");
        cookie.setMaxAge(time);
        response.addCookie(cookie);
    }

}
