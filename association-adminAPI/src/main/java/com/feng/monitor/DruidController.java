package com.feng.monitor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/monitor/druid")
public class DruidController {
    @GetMapping({"/",""})
    public String index(){
        return "redirect:/druid/index.html";
    }
}
