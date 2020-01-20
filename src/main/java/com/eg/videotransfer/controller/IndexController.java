package com.eg.videotransfer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 *
 * @time 2020-01-20 23:14
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "new download";
    }
}
