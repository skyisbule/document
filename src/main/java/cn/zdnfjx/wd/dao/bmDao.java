package cn.zdnfjx.wd.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface bmDao {
    @Insert("insert into bm values (null,#{a1},#{a2},#{a3},#{a4},#{a5})")
    public boolean add(@Param("a1")String a1,
                       @Param("a2")String a2,
                       @Param("a3")String a3,
                       @Param("a4")String a4,
                       @Param("a5")String a5);

    @Select("select a1 from bm where a1=#{a1} limit 1")
    public String chongfu(@Param("a1") String team);
}
