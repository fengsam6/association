package com.feng.controller;


import com.feng.entity.File;
import com.feng.entity.ResponseResult;
import com.feng.service.FileService;
import com.feng.util.ResponseResultUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/files")
public class FileController {
    @Autowired
    private FileService fileService;

    @GetMapping("/{id}")
    public ResponseResult get(@PathVariable("id") Integer id) throws Exception {
        File file = fileService.selectById(id);
        return ResponseResultUtil.renderSuccess(file);
    }

    @GetMapping
    public ResponseResult list(File search, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        PageInfo filePageInfo = fileService.getPage(pageNum, pageSize, search);
        return ResponseResultUtil.renderSuccess(filePageInfo);
    }

    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable("id") Integer id) {
        fileService.deleteById(id);
        return ResponseResultUtil.renderSuccess(id);
    }

}

