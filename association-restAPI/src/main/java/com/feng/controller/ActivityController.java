package com.feng.controller;


import com.feng.entity.Activity;
import com.feng.entity.ResponseResult;
import com.feng.service.ActivityService;
import com.feng.util.ResponseResultUtil;
import com.feng.vo.ActivityPageVo;
import com.feng.vo.ActivityVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@CrossOrigin
@RequestMapping("/activities")
public class ActivityController {
    @Autowired
private ActivityService activityService;
    @GetMapping("/{id}")
    public ResponseResult get(@PathVariable("id") Integer id) throws Exception{
      Activity activity =  activityService.getById(id);
      return ResponseResultUtil.renderSuccess(activity);
    }

    @GetMapping
    public ResponseResult list(Integer activityTypeId, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize) {
        ActivityPageVo activityPageVo = activityService.getPageWithTypeList(pageNum,pageSize,activityTypeId);
        return ResponseResultUtil.renderSuccess(activityPageVo);
    }

    @GetMapping("/top/{n}")
    public ResponseResult getTopN(Activity search, @PathVariable("n") int n) {
        ActivityVo activityVo = activityService.getTopN(n,search);
        return ResponseResultUtil.renderSuccess(activityVo);
    }
}

