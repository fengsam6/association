package com.feng.controller;

import com.feng.entity.ResponseResult;
import com.feng.util.ResponseResultUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rf on 2019/5/10.
 */
@RestController
@RequestMapping("/system")
@Api(tags = "系统配置接口")
public class SystemController {
    @Value("${system.frontIndex}")
    private String accessFrontUrl;

    @GetMapping("/frontUrl")
    public ResponseResult getSystemAccessFrontUrl() {
        return ResponseResultUtil.renderSuccess(accessFrontUrl);
    }
}
