package com.feng.controller;


import com.feng.entity.UserRole;
import com.feng.entity.ResponseResult;
import com.feng.enums.ErrorEnum;
import com.feng.exception.ParamInvalidException;
import com.feng.service.UserRoleService;
import com.feng.util.ResponseResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/userRoles")
@Slf4j
@Api(tags = "用户角色接口")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    @GetMapping
    public ResponseResult list() {
        List<UserRole> userRoleList = userRoleService.selectList(null);
        return ResponseResultUtil.renderSuccess(userRoleList);
    }

    @ApiOperation("通过id获取一个用户角色类型")
    @GetMapping("/{id}")
    public ResponseResult getById(@PathVariable("id") Integer id) {
       UserRole userRole =userRoleService.selectById(id);
        return ResponseResultUtil.renderSuccess(userRole);
    }

    @PutMapping
    @ApiOperation("更新用户角色类型")
    public ResponseResult edit(@Valid UserRole userRole, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            log.error("{}", msg);
            throw new ParamInvalidException(ErrorEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        userRoleService.updateById(userRole);
        return ResponseResultUtil.renderSuccess("更新用户角色类型成功");
    }

    @DeleteMapping("/{id}")
    @ApiOperation("根据id删除用户角色类型")
    public ResponseResult delete(Integer id) {
        userRoleService.deleteById(id);
        return ResponseResultUtil.renderSuccess("删除用户角色类型成功");
    }

    @PostMapping
    @ApiOperation("添加用户角色类型")
    public ResponseResult add(@Valid @RequestBody UserRole userRole, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            log.error("{}", msg);
            throw new ParamInvalidException(ErrorEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        userRoleService.insert(userRole);
        return ResponseResultUtil.renderSuccess("添加用户角色类型成功");
    }
}

