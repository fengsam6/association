package com.feng.controller;


import com.feng.entity.Activity;
import com.feng.entity.ResponseResult;
import com.feng.enums.ErroEnum;
import com.feng.exception.ParamInvalidException;
import com.feng.service.ActivityService;
import com.feng.util.ResponseResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
@CrossOrigin
@RequestMapping("/activities")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping("/{id}")
    public ResponseResult getById(@PathVariable("id") Integer id) {
        Activity activity = activityService.getById(id);
        return ResponseResultUtil.renderSuccess(activity);
    }

    @GetMapping
    public ResponseResult list(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, Activity search) {
       PageInfo<Activity> activityPageInfo = activityService.getPage(pageNum,pageSize,search);
        return ResponseResultUtil.renderSuccess(activityPageInfo);
    }

    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable("id") Integer id) {
        activityService.deleteById(id);
        return ResponseResultUtil.renderSuccess(id);
    }

    @PostMapping
    public ResponseResult add(@Valid @RequestBody Activity activity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErroEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        activityService.add(activity);
        return ResponseResultUtil.renderSuccess("添加活动成功");
    }

    @PutMapping
    public ResponseResult update(@RequestBody @Valid Activity activity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErroEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        activityService.updateWithId(activity);
        return ResponseResultUtil.renderSuccess("更新活动成功");
    }
}

