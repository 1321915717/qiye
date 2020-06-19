package com.zyc.qiye.setvice;

import com.github.pagehelper.PageInfo;
import com.zyc.qiye.pojo.News;

import java.util.List;

public interface NewsSetvice {

    PageInfo<News> select(int pageNum,int pageSize);
    PageInfo<News> search(int pageNum,int pageSize,String title);
    Boolean  insert(News news);
    Boolean delete(int id);
    Boolean  update(News news);
    PageInfo<News> selectByTypeTop(String type,int pageNum,int pageSize);

}
