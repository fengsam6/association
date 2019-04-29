package com.feng.controller;


import com.feng.entity.User;
import com.feng.entity.ResponseResult;
import com.feng.enums.ErroEnum;
import com.feng.exception.ParamInvalidException;
import com.feng.service.UserService;
import com.feng.util.ResponseResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author rf
 * @since 2019-03-03
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseResult getById(@PathVariable("id") Integer id) {
        User user = userService.getById(id);
        return ResponseResultUtil.renderSuccess(user);
    }

    @GetMapping
    public ResponseResult list(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize, User search) {
        PageInfo<User> userList = userService.getUserPage(pageNum, pageSize,search);
        return ResponseResultUtil.renderSuccess(userList);
    }

    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable("id") Integer id) {
        userService.DeleteById(id);
        return ResponseResultUtil.renderSuccess(id);
    }

    @PostMapping
    public ResponseResult add(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErroEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        userService.add(user);
        return ResponseResultUtil.renderSuccess("添加用户成功");
    }

    @PutMapping
    public ResponseResult update(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErroEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        userService.updateById(user);
        return ResponseResultUtil.renderSuccess("更新用户成功");
    }
}

