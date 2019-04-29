package com.feng.controller;


import com.feng.entity.OneColumn;
import com.feng.entity.ResponseResult;
import com.feng.service.OneColumnService;
import com.feng.util.ResponseResultUtil;
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
@RequestMapping("/oneColumns")
public class OneColumnController {
    @Autowired
private OneColumnService oneColumnService;
    @GetMapping("/{id}")
    public ResponseResult get(@PathVariable("id") Integer id) throws Exception{
      OneColumn oneColumn =  oneColumnService.selectById(id);
      return ResponseResultUtil.renderSuccess(oneColumn);
    }

    @GetMapping
    public ResponseResult list(){
       List<OneColumn> oneColumnList =  oneColumnService.selectList(null);
        return ResponseResultUtil.renderSuccess(oneColumnList);
    }
}

