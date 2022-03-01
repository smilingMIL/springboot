package com.boot.service;

import com.boot.bean.News;

public interface NewsService {

    public News getById(Long id);

    public void saveNews(News news);
}
