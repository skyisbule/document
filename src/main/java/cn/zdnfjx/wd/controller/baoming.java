package cn.zdnfjx.wd.controller;

import cn.zdnfjx.wd.dao.bmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class baoming {

    @Autowired
    bmDao data;

    @RequestMapping(value = "/bm",method = RequestMethod.GET)
    public String bm(){
        return "组队";
    }

    @RequestMapping(value = "/bm",method = RequestMethod.POST)
    @ResponseBody
    public String adda(String a1,String a2,String a3,String a4,String a5){
        data.add(a1,a2,a3,a4,a5);
        return "success";
    }

    @RequestMapping("/chongfu")
    @ResponseBody
    public String chongfu(String team){
        if (data.chongfu(team)==null)
            return "1";
        return "0";
    }

}
