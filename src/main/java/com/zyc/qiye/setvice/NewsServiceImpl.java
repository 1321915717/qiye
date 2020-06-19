package com.zyc.qiye.setvice;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyc.qiye.mapper.NewsMapper;
import com.zyc.qiye.pojo.News;
import com.zyc.qiye.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsSetvice {
    @Autowired
    private NewsMapper newsMapper;

    @Override
    public PageInfo<News> select(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        return new PageInfo<>(newsMapper.select());
    }

    @Override
    public PageInfo<News> search(int pageNum, int pageSize, String title) {
        PageHelper.startPage(pageNum,pageSize);

        return new PageInfo<>(newsMapper.search(title));
    }

    @Override
    public Boolean insert(News news) {
      int code=  newsMapper.insert(news);
        if(code>0){
            return  true;
        }
        return false;
    }

    @Override
    public Boolean delete(int id) {
        int code=newsMapper.delete(id);
        if(code>0){
            return  true;
        }

        return false;
    }

    @Override
    public Boolean update(News news) {
        int code=  newsMapper.update(news);
        if(code>0){
            return  true;
        }
        return false;
    }

    @Override
    public PageInfo<News> selectByTypeTop(String type,int pageNum,int pageSize) {


        PageHelper.startPage(pageNum,pageSize);

      return   new PageInfo<>(newsMapper.selectByTypeTop(type));

    }
}
