package com.feng.controller;


import com.feng.entity.ResponseResult;
import com.feng.entity.User;
import com.feng.enums.ExceptionEnum;
import com.feng.exception.BusinessException;
import com.feng.service.UserService;
import com.feng.util.ResponseResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseResult get(@PathVariable("id") Integer id) throws Exception {
        User user = userService.getById(id);
        return ResponseResultUtil.renderSuccess(user);
    }

    @GetMapping("/list/{pageSize}/{pageNum}")
    public ResponseResult list(@PathVariable @RequestParam(defaultValue = "1") int pageNum, @PathVariable @RequestParam(defaultValue = "10") int pageSize) {
        List<User> userList = userService.getUserPage(pageSize, pageNum);
        return ResponseResultUtil.renderSuccess(userList);
    }

}

