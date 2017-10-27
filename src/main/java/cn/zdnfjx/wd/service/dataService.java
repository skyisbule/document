package cn.zdnfjx.wd.service;

import cn.zdnfjx.wd.dao.data;
import cn.zdnfjx.wd.domain.doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


@Service
public class dataService {
    @Autowired
    data data;

    public static StringBuilder result = new StringBuilder();


    /**
     *
     * @param data 含有所有数据的List
     * @param id   当前应该出理的集合的爸爸id
     * @return     处理好后的html文本
     */
    @SuppressWarnings("unchecked")
    private String createTree(List<doc> data,int id){

        StringBuilder res = new StringBuilder();

        if (data.isEmpty())
            return res.toString();

        List<doc> now = new LinkedList();
        //取出所有子节点
        for (doc temp : data){
            if (temp.getFather()==id)
                now.add(temp);
        }
        if (!now.isEmpty()) {
            for (doc temp : now) {
                if (temp.getIsfolder() == 0) {
                    System.out.println("true");
                    res.append("<li><a href=\"\">");
                    res.append(temp.getName());
                    res.append("</a></li>\n");
                } else {
                    res.append("<ul>");
                    res.append(createTree(data,temp.getId()));
                }
            }
        }
        res.append("</ul>");
        return res.toString();
    }


    public List<doc> getAllByFather(String father, String belongto){
        List<doc> allData = data.getAllByFather(father,belongto);
        return allData;
    }

    public boolean add(doc doc){
        return data.add(doc.getName(),
                doc.getContent(),
                doc.getIsfolder(),
                doc.getFather(),
                doc.getBelongto());
    }

    public boolean addContent(String content,int id){
        return data.addContent(id,content);
    }

    public String getId(){return data.getId();}

    public boolean deleteById(int id){return data.deleteById(id);}

    public boolean rename(String newname,int id){return data.rename(newname,id);}

    public String getPowerByName(String name){return data.getPowerByName(name);}
}
