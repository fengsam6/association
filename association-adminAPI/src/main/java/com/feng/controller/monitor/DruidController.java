package com.feng.controller.monitor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/monitor/druid")
@ApiIgnore
public class DruidController {
    @GetMapping({"/",""})
    public String index(){
        return "redirect:/druid/index.html";
    }
}
