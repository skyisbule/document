package cn.zdnfjx.wd.dao;

import org.apache.ibatis.annotations.*;

import cn.zdnfjx.wd.domain.doc;

import java.util.List;

@Mapper
public interface data {
    @Select("select * from data where father=#{father} and belongto=#{belongto} and isdelete=0")
    @ResultType(cn.zdnfjx.wd.domain.doc.class)
    public List<doc> getAllByFather(@Param("father") String father, @Param("belongto") String belongto);

    @Insert("insert into data values(null,#{name},#{content},#{isfolder},#{father},#{belongto},0)")
    public boolean add(@Param("name")String name,
                       @Param("content")String content,
                       @Param("isfolder")int isfolder,
                       @Param("father")int father,
                       @Param("belongto")int belongto);

    @Update("update data set content=#{content} where id=#{id}")
    public boolean addContent(@Param("id")int id,
                              @Param("content")String content);

    @Select("select max(id) from data")
    public String getId();

    @Update("update data set isdelete=1 where id=#{id}")
    public boolean deleteById(@Param("id") int id);

    @Update("update data set name=#{newname} where id=#{id}")
    public boolean rename(@Param("newname")String name,
                          @Param("id")int id);

    @Select("select power from user where name=#{name}")
    public String getPowerByName(String name);
}
