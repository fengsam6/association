package com.feng.controller;


import com.feng.email.MailService;
import com.feng.entity.ResponseResult;
import com.feng.entity.User;
import com.feng.enums.ErroEnum;
import com.feng.exception.BusinessException;
import com.feng.exception.ParamInvalidException;
import com.feng.service.UserService;
import com.feng.util.RedisOption;
import com.feng.util.ResponseResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author rf
 * @since 2019-03-03
 */
@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MailService mailService;
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private TemplateEngine templateEngine;


    @GetMapping("/{id}")
    public ResponseResult get(@PathVariable("id") Integer id) throws Exception {
        User user = userService.getById(id);
        return ResponseResultUtil.renderSuccess(user);
    }


    @PostMapping("/login")
    public ResponseResult login(String code, @Valid @RequestBody User user, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            log.error("{}", msg);
            throw new ParamInvalidException(ErroEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        String katchaCode = (String) session.getAttribute("rightCode");
        if (StringUtils.isEmpty(code) || !katchaCode.equals(code.trim())) {
            throw new BusinessException(ErroEnum.USER_CODE_ERROR);
        }
        userService.login(user);
//        redisOption.set(redisOption.getUserSessionPrefix()+user.getId(),user);
//        //用户登录session设置30分钟
//        redisOption.expire(redisOption.getUserSessionPrefix()+user.getId(),30*60*60);

        session.setAttribute("userSession", user);
        return ResponseResultUtil.renderSuccess("用户登录成功！");
    }

    @PostMapping("/register")
    public ResponseResult register(@Valid @RequestBody User user, String rePassword, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErroEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        userService.register(user, rePassword);
        sendActiveMail(user);
        return ResponseResultUtil.renderSuccess("用注册录成功,请尽快激活邮箱！");
    }

    @GetMapping("/activeAccount")
    public ResponseResult activeAccount(User user, String code) {
        user.setActive(true);
        userService.updateById(user);
        return ResponseResultUtil.renderSuccess("账号激活成功！");
    }

    private void sendActiveMail(User user) {
        Context context = new Context();
        context.setVariable("email", user.getAccount());
        context.setVariable("id", user.getId());
        String content = templateEngine.process("/activeMail", context);
        mailService.sendSimpleMail("激活邮箱", content, user.getAccount());
    }
}

