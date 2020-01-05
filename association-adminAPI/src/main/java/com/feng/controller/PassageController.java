package com.feng.controller;


import com.feng.dto.PassageTypeDto;
import com.feng.dto.PassageFileDto;
import com.feng.entity.Passage;
import com.feng.entity.ResponseResult;
import com.feng.enums.ErrorEnum;
import com.feng.exception.ParamInvalidException;
import com.feng.service.PassageService;
import com.feng.util.ResponseResultUtil;
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
@RequestMapping("/passages")
@Api(value = "社团管理系统后台文章管理接口",tags = "社团管理系统后台文章管理接口")
public class PassageController {
    @Autowired
    private PassageService passageService;

    @ApiOperation("通过id获取一篇文章详细信息")
    @GetMapping("/{id}")
    public ResponseResult getInfoById(@PathVariable("id") Integer id) {
        PassageFileDto passageFileDto = passageService.getInfoById(id);
        return ResponseResultUtil.renderSuccess(passageFileDto);
    }

    @GetMapping
    @ApiOperation("根据条件分页查询所有文章")
    public ResponseResult list(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize, Passage search) {
        PageInfo<PassageTypeDto> passageList = passageService.findPage(pageNum, pageSize, search);
        return ResponseResultUtil.renderSuccess(passageList);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("通过id删除一篇文章")
    public ResponseResult delete(@PathVariable("id") Integer id) {
        passageService.deleteById(id);
        return ResponseResultUtil.renderSuccess(id);
    }

    @PostMapping
    @ApiOperation("添加一篇文章")
    public ResponseResult add(@Valid @RequestBody Passage passage, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErrorEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        passageService.add(passage);
        System.out.println(passage.getId());
        return ResponseResultUtil.renderSuccess(passage.getId());
    }

    @PutMapping
    @ApiOperation("通过id更新一篇文章")
    public ResponseResult update(@RequestBody @Valid PassageFileDto passage, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErrorEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        passageService.updateInfoById(passage);
        return ResponseResultUtil.renderSuccess("更新文章成功");
    }
}

