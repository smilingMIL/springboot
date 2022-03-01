package com.boot.mapper;

import com.boot.bean.News;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
                /*混合模式  (注解加配置)*/
@Mapper
public interface NewsMapper {
                /*注解模式*/
    @Select("select * from news where id=#{id}")
    public News getById(Long id);

/*    @Insert("insert into news(name,content,url)values(#{name},#{content},#{url}")
    @Options(useGeneratedKeys = true,keyProperty = "id") : 注解版的设置标签中的属性值*/
    public void insert(News news);

}
