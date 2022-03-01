package com.boot.service.impl;

import com.boot.bean.Book;
import com.boot.mapper.BookMapper;
import com.boot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    public Book getBookById(Long id){
        return bookMapper.getBook(id);
    }
}
