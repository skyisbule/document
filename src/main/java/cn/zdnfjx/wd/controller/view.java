package cn.zdnfjx.wd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class view {
    @RequestMapping("/")
    public String index(){return "index";}
}
