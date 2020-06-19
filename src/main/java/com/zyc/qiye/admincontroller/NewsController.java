package com.zyc.qiye.admincontroller;

import com.zyc.qiye.pojo.News;
import com.zyc.qiye.setvice.NewsSetvice;
import com.zyc.qiye.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RequestMapping("/admin/news")
@RestController
public class NewsController {

    @Autowired
    private NewsSetvice newsSetvice;

    @RequestMapping("/findNews")
    public  Object findNews(
            @RequestParam("pageNum")int pageNum,
            @RequestParam("pageSize")int pageSize
    ){
        return ResponseUtil.ok(newsSetvice.select(pageNum,pageSize));


    }

    @RequestMapping("/searchNews")
    public  Object searchNews(
            @RequestParam("pageNum")int pageNum,
            @RequestParam("pageSize")int pageSize,
            @RequestParam("title") String title
    ){
        return ResponseUtil.ok(newsSetvice.search(pageNum,pageSize,title));


    }

    @RequestMapping("/addNews")
    public  Object addNews(
            @RequestParam("title")String title,
            @RequestParam("content")String content,
             @RequestParam("img")String img,
            @RequestParam("type")String type
    ){

        News news =new News();
        news.setnType(type);
        news.setnImg(img);
        news.setnContent(content);
        news.setnDate(new Date());
        news.setnTitle(title);

       Boolean b= newsSetvice.insert(news);
            if(b){
                return  ResponseUtil.ok();
            }

            return  ResponseUtil.fail();
    }

    @RequestMapping("/updateNews")
    public  Object updateNews(
            @RequestParam("id")int id,
            @RequestParam("title")String title,
            @RequestParam("content")String content,
            @RequestParam("img")String img,
            @RequestParam("type")String type
    ){

        News news =new News();
        news.setnId(id);
        news.setnContent(content);
        news.setnDate(new Date());
        news.setnTitle(title);
        news.setnType(type);
        news.setnImg(img);
        Boolean b= newsSetvice.update(news);
        if(b){
            return  ResponseUtil.ok();
        }

        return  ResponseUtil.fail();
    }

    @RequestMapping("/delete")
    public  Object delete(
            @RequestParam("id")int id
    ){
        Boolean b= newsSetvice.delete(id);
        if(b){
            return  ResponseUtil.ok();
        }

        return  ResponseUtil.fail();
    }

}
