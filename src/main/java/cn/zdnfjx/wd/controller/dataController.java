package cn.zdnfjx.wd.controller;


import cn.zdnfjx.wd.domain.doc;
import cn.zdnfjx.wd.service.dataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class dataController {

    @Autowired
    private dataService data;

    //传所属的部门+父亲id，返回所有的信息。
    @RequestMapping("/api/getallbyfather")
    public List<doc> getAllByBelongAndFather(String father, String belongto){
        return data.getAllByFather(father,belongto);
    }

    //传一切信息添加一条记录
    @RequestMapping("/api/add")
    public synchronized String add(doc doc){
        if (data.add(doc))
            return data.getId();
        return "error";
    }

    //修改一组数据的内容
    @RequestMapping("/api/content")
    public  String addContent(String content,int id){
        if (data.addContent(content,id))
            return "success";
        return "error";
    }

    @RequestMapping("/api/delete")
    public String delete(int id){
        if (data.deleteById(id))
            return "success";
        return "error";
    }

    @RequestMapping("/api/rename")
    public String rename(String newname,int id){
        if (data.rename(newname,id))
            return "success";
        return "error";
    }

}
