package com.feng.controller;


import com.feng.dto.PassageFileDto;
import com.feng.entity.ResponseResult;
import com.feng.util.ResponseResultUtil;
import com.feng.entity.Passage;
import com.feng.service.PassageService;
import com.feng.vo.PassagePageVo;
import com.feng.vo.PassageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/passages")
@Api(tags = "社团管理系统前台文章接口")
public class PassageController {
    @Autowired
    private PassageService passageService;
    @ApiOperation("通过id获取一篇文章详细信息")
    @GetMapping("/{id}")
    public ResponseResult getInfoById(@PathVariable("id") Integer id) {
        PassageFileDto passageInfoVo = passageService.getInfoById(id);
        return ResponseResultUtil.renderSuccess(passageInfoVo);
    }


    @ApiOperation("根据条件分页查询所有文章")
    @GetMapping
    public ResponseResult list(Integer passageTypeId, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize) {
        PassagePageVo passagePageVo = passageService.getPageWithTypeList(pageNum, pageSize,passageTypeId);
        return ResponseResultUtil.renderSuccess(passagePageVo);
    }
    @ApiOperation("查找最近发布的n篇新闻")
    @GetMapping("/top/{n}")
    public ResponseResult getTopN(Passage search, @PathVariable("n") int n) {
        PassageVo passageVo = passageService.getTopN(n,search);
        return ResponseResultUtil.renderSuccess(passageVo);
    }
}

