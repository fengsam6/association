package com.feng.controller;


import com.feng.entity.Club;
import com.feng.entity.ResponseResult;
import com.feng.service.ClubService;
import com.feng.util.ResponseResultUtil;
import com.feng.vo.ActivityPageVo;
import com.feng.vo.ClubPageVo;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
@CrossOrigin
@RequestMapping("/clubs")
@Api(tags = "社团管理系统前台社团接口")
public class ClubController {
    @Autowired
    private ClubService clubService;

    @GetMapping("/{num}")
    @ApiOperation("通过社团编号num查看一个社团")
    public ResponseResult get(@PathVariable("num") Integer num) throws Exception {
        Club club = clubService.getById(num);
        return ResponseResultUtil.renderSuccess(club);
    }

    @GetMapping
    @ApiOperation("根据条件分页查询所有社团")
    public ResponseResult list(Integer clubTypeId, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        ClubPageVo clubPageVo = clubService.getPageWithTypeList(pageNum, pageSize, clubTypeId);
        return ResponseResultUtil.renderSuccess(clubPageVo);
    }
}

