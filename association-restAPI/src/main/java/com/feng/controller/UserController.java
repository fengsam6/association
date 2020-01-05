package com.feng.controller;


import com.feng.email.MailService;
import com.feng.entity.ResponseResult;
import com.feng.entity.User;
import com.feng.enums.ErrorEnum;
import com.feng.exception.ParamInvalidException;
import com.feng.service.UserService;
import com.feng.util.ResponseResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.validation.Valid;

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
@Api(tags = "前台用户接口")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MailService mailService;
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private TemplateEngine templateEngine;

    @ApiOperation("通过用户id获取一个用户")
    @GetMapping("/{id}")
    public ResponseResult get(@PathVariable("id") Integer id) throws Exception {
        User user = userService.getById(id);
        return ResponseResultUtil.renderSuccess(user);
    }



    @ApiOperation("前台用户注册接口")
    @PostMapping("/register")
    public ResponseResult register(@Valid @RequestBody User user, String rePassword, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErrorEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        userService.register(user, rePassword);
        sendActiveMail(user);
        return ResponseResultUtil.renderSuccess("用注册录成功,请尽快激活邮箱！");
    }
    @ApiOperation("用户邮箱激活")
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

