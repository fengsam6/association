package com.feng.controller;


import com.feng.entity.Activity;
import com.feng.entity.ResponseResult;
import com.feng.enums.ErroEnum;
import com.feng.exception.ParamInvalidException;
import com.feng.service.ActivityService;
import com.feng.util.ResponseResultUtil;
import com.feng.vo.ActivityInfoVo;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api("社团管理系统后台活动管理接口")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @ApiOperation("通过id获取一个活动")
    @GetMapping("/{id}")
    public ResponseResult getById(@PathVariable("id") Integer id) {
        ActivityInfoVo activity = activityService.getById(id);
        return ResponseResultUtil.renderSuccess(activity);
    }

    @ApiOperation("根据条件分页查询所有活动")
    @GetMapping
    public ResponseResult list(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize, Activity search) {
        PageInfo<ActivityInfoVo> activityPageInfo = activityService.getPage(pageNum, pageSize, search);
        return ResponseResultUtil.renderSuccess(activityPageInfo);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("通过id删除一个活动")
    public ResponseResult delete(@PathVariable("id") Integer id) {
        activityService.deleteById(id);
        return ResponseResultUtil.renderSuccess(id);
    }

    @PostMapping
    @ApiOperation("添加一个活动")
    public ResponseResult add(@Valid @RequestBody Activity activity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErroEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        activityService.add(activity);
        return ResponseResultUtil.renderSuccess("添加活动成功");
    }

    @PutMapping
    @ApiOperation("通过id更新一个活动")
    public ResponseResult update(@RequestBody @Valid ActivityInfoVo activity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErroEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        activityService.updateWithId(activity);
        return ResponseResultUtil.renderSuccess("更新活动成功");
    }
}

