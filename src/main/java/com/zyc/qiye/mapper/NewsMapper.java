package com.zyc.qiye.mapper;

import com.zyc.qiye.pojo.News;

import java.util.List;

public interface NewsMapper {


    List select();
    List search(String title);
    int   insert(News news);
     int  update(News news);
     int  delete(int id);
    List  selectByTypeTop(String type);
    News selectByNid(int id);
}
