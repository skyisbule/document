package cn.zdnfjx.wd.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface userDao {

    @Select("select passwd from user where name=#{username}")
    public String getPasswd(String username);
}
