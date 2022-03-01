package com.boot.service.impl;

import com.boot.bean.News;
import com.boot.mapper.NewsMapper;
import com.boot.service.NewsService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsMapper newsMapper;

    Counter counter;

    public NewsServiceImpl(MeterRegistry meterRegistry){
        counter = meterRegistry.counter("newsService.saveNews.count");

    }


    public News getById(Long id){
        return newsMapper.getById(id);
    }

    public void saveNews(News news){
        counter.increment();//每次调用都增加一次
        newsMapper.insert(news);
    }


}
