package com.feng.controller;


import com.feng.entity.ResponseResult;
import com.feng.util.ResponseResultUtil;
import com.feng.entity.Passage;
import com.feng.service.PassageService;
import com.feng.vo.PassagePageVo;
import com.feng.vo.PassageVo;
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
public class PassageController {
    @Autowired
    private PassageService passageService;

    @GetMapping("/{id}")
    public ResponseResult get(@PathVariable("id") Integer id) throws Exception {
        Passage passage = passageService.getById(id);
        return ResponseResultUtil.renderSuccess(passage);
    }

    @GetMapping
    public ResponseResult list(Integer passageTypeId, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "8") int pageSize) {
        PassagePageVo passagePageVo = passageService.getPageWithTypeList(pageNum, pageSize,passageTypeId);
        return ResponseResultUtil.renderSuccess(passagePageVo);
    }
    @GetMapping("/top/{n}")
    public ResponseResult getTopN(Passage search, @PathVariable("n") int n) {
        PassageVo passageVo = passageService.getTopN(n,search);
        return ResponseResultUtil.renderSuccess(passageVo);
    }
}

