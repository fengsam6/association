package com.feng.controller;


import com.feng.entity.ActivityType;
import com.feng.entity.ResponseResult;
import com.feng.service.ActivityTypeService;
import com.feng.util.ResponseResultUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author rf
 * @since 2019-03-03
 */
@RestController
@RequestMapping("/activityTypes")
@Api(tags = "前台活动类型接口")
public class ActivityTypeController {
    @Autowired
    private ActivityTypeService activityTypeService;
    @GetMapping
    public ResponseResult list() {
        List<ActivityType> activityTypeList= activityTypeService.selectList(null);
        return ResponseResultUtil.renderSuccess(activityTypeList);
    }
}

