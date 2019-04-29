package com.feng.controller;


import com.feng.entity.Passage;
import com.feng.entity.PassageType;
import com.feng.entity.ResponseResult;
import com.feng.service.PassageTypeService;
import com.feng.util.ResponseResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/passageTypes")
public class PassageTypeController {
    @Autowired
    private PassageTypeService passageTypeService;
    @GetMapping
    public ResponseResult list() {
        List<PassageType> passageTypeList= passageTypeService.selectList(null);
        return ResponseResultUtil.renderSuccess(passageTypeList);
    }
}

