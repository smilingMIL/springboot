package com.boot.mapper;

import com.boot.bean.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {

    public Book getBook(Long id);
}
