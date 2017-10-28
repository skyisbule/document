package cn.zdnfjx.wd.controller;


import cn.zdnfjx.wd.domain.doc;
import cn.zdnfjx.wd.service.dataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class dataController {

    @Autowired
    private dataService data;

    //传所属的部门+父亲id，返回所有的信息。
    @RequestMapping(value = "/api/getallbyfather",method = RequestMethod.POST)
    public List<doc> getAllByBelongAndFather(String father,
                                             String belongto
            //, @CookieValue("name")String name
    ){

        //暂时先设成只要登录就能看
      //  String power = data.getPowerByName(name);
      //  if (!auth(power,belongto))
      //      return new LinkedList<doc>();

        return data.getAllByFather(father,belongto);
    }

    //传一切信息添加一条记录
    @RequestMapping(value = "/api/add",method = RequestMethod.POST)
    public synchronized String add(doc doc
            //,@CookieValue("name")String name
    ){
     //   String power = data.getPowerByName(name);
     //   if (!auth(power,String.valueOf(doc.getBelongto())))
     //       return "auth error";

        if (data.add(doc))
            return data.getId();
        return "database error";
    }

    //修改一组数据的内容
    @RequestMapping(value = "/api/content",method = RequestMethod.POST)
    public  String addContent(String content,int id){
        if (data.addContent(content,id))
            return "success";
        return "error";
    }

    @RequestMapping(value = "/api/delete",method = RequestMethod.POST)
    public String delete(int id){
        if (data.deleteById(id))
            return "success";
        return "error";
    }

    @RequestMapping(value = "/api/rename",method = RequestMethod.POST)
    public String rename(String newname,int id){
        if (data.rename(newname,id))
            return "success";
        return "error";
    }

    private boolean auth(String power,String belongto){
        if (power.contains(belongto)){
            return true;
        }
        return false;
    }

}
