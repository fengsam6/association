package com.feng.controller;


import com.feng.entity.Passage;
import com.feng.entity.ResponseResult;
import com.feng.enums.ExceptionEnum;
import com.feng.exception.ParamInvalidException;
import com.feng.service.PassageService;
import com.feng.util.ResponseResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
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
@CrossOrigin
@RequestMapping("/admin/passages")
public class PassageController {
    @Autowired
    private PassageService passageService;

    @GetMapping("/{id}")
    public ResponseResult getById(@PathVariable("id") Integer id) {
        Passage passage = passageService.getById(id);
        return ResponseResultUtil.renderSuccess(passage);
    }

    @GetMapping
    public ResponseResult list(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, Passage search) {
        List<Passage> passageList = passageService.getPage(pageNum, pageSize, search);
        return ResponseResultUtil.renderSuccess(passageList);
    }

    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable("id") Integer id) {
        passageService.deleteById(id);
        return ResponseResultUtil.renderSuccess(id);
    }

    @PostMapping
    public ResponseResult add(@Valid @RequestBody Passage passage, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ExceptionEnum.INVALIDATE_EXCEPTION.setMsg(msg));
        }
        passageService.add(passage);
        return ResponseResultUtil.renderSuccess("添加文章成功");
    }

    @PutMapping
    public ResponseResult update(@RequestBody @Valid Passage passage, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ExceptionEnum.INVALIDATE_EXCEPTION.setMsg(msg));
        }
        passageService.updateWithId(passage);
        return ResponseResultUtil.renderSuccess("更新文章成功");
    }
}

