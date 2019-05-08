package com.feng.controller;

import com.google.code.kaptcha.Constants;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by rf on 2019/5/3.
 */
@RestController
@CrossOrigin
public class Test {
    @GetMapping("/setSessionId")
    public String setredisResult(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("userId","1");
        return "设置ok...";
    }
    @GetMapping("/getSessionId")
    public String redisResult(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userid = (String) session.getAttribute("userId");
        return "userId:"+userid;
    }
    @GetMapping("/getCode")
    public String getCode(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userid = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        return "code:"+userid;
    }

    @GetMapping("/geUserId")
    public String geUserId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userid = (String) session.getAttribute("userId");
        return "geUserId:"+userid;
    }
}
