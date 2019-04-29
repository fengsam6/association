package com.feng.controller;


import com.feng.entity.Club;
import com.feng.entity.ResponseResult;
import com.feng.enums.ErroEnum;
import com.feng.exception.ParamInvalidException;
import com.feng.service.ClubService;
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
@RequestMapping("/clubs")
public class ClubController {
    @Autowired
    private ClubService clubService;

    @GetMapping("/{num}")
    public ResponseResult get(@PathVariable("num") Integer num) throws Exception {
        Club club = clubService.getById(num);
        return ResponseResultUtil.renderSuccess(club);
    }

    @GetMapping
    public ResponseResult list(Club search, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        PageInfo clubPageInfo = clubService.getPage(pageNum, pageSize, search);
        return ResponseResultUtil.renderSuccess(clubPageInfo);
    }

    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable("id") Integer id) {
        clubService.deleteById(id);
        return ResponseResultUtil.renderSuccess(id);
    }

    @PostMapping
    public ResponseResult add(@Valid @RequestBody Club club, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErroEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        clubService.add(club);
        return ResponseResultUtil.renderSuccess("添加社团成功");
    }

    @PutMapping
    public ResponseResult update(@RequestBody @Valid Club club, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            throw new ParamInvalidException(ErroEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(msg));
        }
        clubService.updateWithId(club);
        return ResponseResultUtil.renderSuccess("更新社团成功");
    }
}

