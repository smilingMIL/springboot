package com.boot.springboot03web01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {


    @GetMapping("/atguigu")
    public String atguigu(Model model){

        //Model 中的数据会被放到请求域中 request.setAttribute("",);
        model.addAttribute("msg","你好 guigu");
        model.addAttribute("link","http://www.baidu.com");
        return "success";
    }
}
