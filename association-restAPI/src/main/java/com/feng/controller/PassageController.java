package com.feng.controller;


import com.feng.entity.ResponseResult;
import com.feng.enums.ExceptionEnum;
import com.feng.exception.BusinessException;
import com.feng.exception.ParamInvalidException;
import com.feng.util.ResponseResultUtil;
import com.feng.entity.Passage;
import com.feng.service.PassageService;
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
@RequestMapping("/passages")
public class PassageController {
    @Autowired
private PassageService passageService;
    @GetMapping("/{id}")
    public ResponseResult get(@PathVariable("id") Integer id) throws Exception{
      Passage passage =  passageService.getById(id);
      return ResponseResultUtil.renderSuccess(passage);
    }

    @GetMapping
    public ResponseResult list(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize ){
       List<Passage> passageList =  passageService.getPage(pageNum,pageSize,null);
        return ResponseResultUtil.renderSuccess(passageList);
    }
}

