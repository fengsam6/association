package com.feng.controller;


import com.feng.constants.AppConstant;
import com.feng.entity.ResponseResult;
import com.feng.entity.User;
import com.feng.enums.ErroEnum;
import com.feng.exception.AuthenticationFailException;
import com.feng.exception.BusinessException;
import com.feng.exception.ParamInvalidException;
import com.feng.service.UserService;
import com.feng.util.CookieUtil;
import com.feng.util.RedisOption;
import com.feng.util.ResponseResultUtil;
import com.feng.util.UUIDUtil;
import com.feng.vo.LoginUserVo;
import com.github.pagehelper.PageInfo;
import com.google.code.kaptcha.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
@RequestMapping("/users")
@Slf4j
@CrossOrigin(allowCredentials = "true")
@Api("社团管理系统后台用户管理接口")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisOption redisOption;
    @Autowired
    private AppConstant appConstant;

    @GetMapping("/{id}")
    @ApiOperation("通过id获取一个用户")
    public ResponseResult getById(@PathVariable("id") Integer id) {
        User user = userService.getById(id);
        return ResponseResultUtil.renderSuccess(user);
    }

    @GetMapping("/getUser")
    @ApiOperation("通过token获取一个用户")
    public ResponseResult getByToken(@RequestParam(defaultValue = "") String token) {
        Integer userId = (Integer) redisOption.get(token);
        User user = userService.getById(userId);
        return ResponseResultUtil.renderSuccess(user);
    }

    @GetMapping
    @ApiOperation("根据条件分页查询所有用户")
    public ResponseResult list(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize, User search) {
        PageInfo<User> userList = userService.getUserPage(pageNum, pageSize, search);
        return ResponseResultUtil.renderSuccess(userList);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("通过id删除一个用户")
    public ResponseResult delete(@PathVariable("id") Integer id) {
        userService.DeleteById(id);
        return ResponseResultUtil.renderSuccess(id);
    }

    @PostMapping
    @ApiOperation("添加一个用户")
    public ResponseResult add(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErroEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        userService.add(user);
        return ResponseResultUtil.renderSuccess("添加用户成功");
    }

    @PutMapping
    @ApiOperation("通过id更新一个用户")
    public ResponseResult update(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErroEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        userService.updateById(user);
        return ResponseResultUtil.renderSuccess("更新用户成功");
    }

    @ApiOperation("用户登录接口")
    @PostMapping("/login")
    public ResponseResult login(@Valid @RequestBody LoginUserVo userVo, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            log.error("{}", msg);
            throw new ParamInvalidException(ErroEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        String code = userVo.getCode();
        String codeKey = CookieUtil.getCookie(request, Constants.KAPTCHA_SESSION_KEY);
        String katchaCode = (String) redisOption.get(codeKey);
        log.info("{}", katchaCode);

        if (StringUtils.isEmpty(code) || !katchaCode.equals(code.trim())) {
            throw new BusinessException(ErroEnum.USER_CODE_ERROR);
        }

        User loginUser = userService.login(userVo);
        String token = UUIDUtil.getUUID();
        if (loginUser != null) {
            redisOption.set(token, loginUser.getId());
        }

        return ResponseResultUtil.renderSuccess(token);
    }

    @ApiOperation("用户登录接口")
    @PostMapping("/login2")
    public ResponseResult login2(@Valid @RequestBody LoginUserVo userVo, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            log.error("{}", msg);
            throw new ParamInvalidException(ErroEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        String code = userVo.getCode();
        String codeKey = CookieUtil.getCookie(request, Constants.KAPTCHA_SESSION_KEY);
        String katchaCode = (String) redisOption.get(codeKey);
        log.info("{}", katchaCode);

        if (StringUtils.isEmpty(code) || !katchaCode.equals(code.trim())) {
            throw new BusinessException(ErroEnum.USER_CODE_ERROR);
        }
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(userVo.getAccount(), userVo.getPassword());

        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            throw new BusinessException(ErroEnum.USER_NAME_ERROR);
        }catch (AuthenticationFailException e){
            throw new BusinessException(ErroEnum.USER_PASSWORD_ERROR);
        }
        return ResponseResultUtil.renderSuccess(token);
    }

    /**
     * 注销登录
     *
     * @param session
     * @return
     */
    @GetMapping("/logout")
    @ApiOperation("用户登录接口")
    public ResponseResult logout(HttpSession session) {
        session.invalidate();//使Session变成无效，及用户退出
        SecurityUtils.getSubject().logout();
        return ResponseResultUtil.renderSuccess("成功退出系统！");
    }

}

