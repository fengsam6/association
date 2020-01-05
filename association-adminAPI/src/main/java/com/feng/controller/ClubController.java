package com.feng.controller;


import com.feng.entity.Club;
import com.feng.entity.ResponseResult;
import com.feng.enums.ErrorEnum;
import com.feng.exception.ParamInvalidException;
import com.feng.service.ClubService;
import com.feng.util.ResponseResultUtil;
import com.feng.vo.ClubInfoVo;
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
@RequestMapping("/clubs")
@Api(value = "社团管理系统后台文章管理接口",tags = "社团管理系统后台文章管理接口")
public class ClubController {
    @Autowired
    private ClubService clubService;

    @ApiOperation("通过社团编号num查看一个社团")
    @GetMapping("/{num}")
    public ResponseResult get(@PathVariable("num") Integer num) throws Exception {
        Club club = clubService.getById(num);
        return ResponseResultUtil.renderSuccess(club);
    }

    @ApiOperation("根据条件分页查询所有社团")
    @GetMapping
    public ResponseResult list(Club search, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        PageInfo<ClubInfoVo> clubPageInfo = clubService.getPage(pageNum, pageSize, search);
        return ResponseResultUtil.renderSuccess(clubPageInfo);
    }

    @ApiOperation("通过id删除一个社团")
    @DeleteMapping("/{num}")
    public ResponseResult delete(@PathVariable("num") Integer num) {
        clubService.deleteById(num);
        return ResponseResultUtil.renderSuccess(num);
    }

    @ApiOperation("添加一个社团")
    @PostMapping
    public ResponseResult add(@Valid @RequestBody Club club, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErrorEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        clubService.add(club);
        return ResponseResultUtil.renderSuccess("添加社团成功");
    }

    @ApiOperation("通过id更新一个社团")
    @PutMapping
    public ResponseResult update(@RequestBody @Valid Club club, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErrorEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        clubService.updateWithId(club);
        return ResponseResultUtil.renderSuccess("更新社团成功");
    }
}

