package com.feng.controller.monitor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/monitor/swagger")
@ApiIgnore
public class SwaggerController {
    @GetMapping({"/",""})
    public String apiSwaggerPage(){
        return "forward:/swagger-ui.html";
    }
}
