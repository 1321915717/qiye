package com.zyc.qiye.admincontroller;

import com.zyc.qiye.pojo.Goods;
import com.zyc.qiye.setvice.GoodsService;
import com.zyc.qiye.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RequestMapping("/admin/goods")
@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/find")
    public  Object findGoods(
            @RequestParam("pageNum")int pageNum,
            @RequestParam("pageSize")int pageSize
    ){

        return ResponseUtil.ok(goodsService.select(pageNum,pageSize));
    }
    @RequestMapping("/delete")
    public  Object deleteGoods(
            @RequestParam("gid")int gid

    ){
            Boolean b=goodsService.delete(gid);
            if(b){
                return  ResponseUtil.ok();
            }
        return  ResponseUtil.fail();
    }

    @RequestMapping("/insert")
    public  Object insert(
            @RequestParam("video")String video,
            @RequestParam("lun")String  lun,
            @RequestParam("img")String img,
            @RequestParam("title")String title,
            @RequestParam("content")String content,
            @RequestParam("cid")int  cid,
            @RequestParam("type")String type



    ){

       Boolean b =goodsService.insert(video,lun,img,title,content,cid,type);
       if(b){
           return  ResponseUtil.ok();
       }
       return ResponseUtil.fail();
    }

    @RequestMapping("/update")
    public  Object update(
            @RequestParam("video")String video,
            @RequestParam("lun")String  lun,
            @RequestParam("img")String img,
            @RequestParam("title")String title,
            @RequestParam("content")String content,
            @RequestParam("cid")int  cid,
            @RequestParam("type")String type,
            @RequestParam("gid")int gid



    ){
        Goods goods =new Goods();
        goods.setgVideo(video);
        goods.setgLun(lun);
        goods.setgImg(img);
        goods.setgTitle(title);
        goods.setgContent(content);
        goods.setcId(cid);
        goods.setgId(gid);
        goods.setgDate(new Date());
        goods.setgType(type);

        Boolean b =goodsService.update(goods);
        if(b){
            return  ResponseUtil.ok();
        }
        return ResponseUtil.fail();
    }

    @RequestMapping("findByType")
    public  Object findByType(
            @RequestParam("pageNum")int pageNum,
            @RequestParam("pageSize")int pageSize,
            @RequestParam("title")String title,
            @RequestParam("cid")String cid
    ){

        Goods goods =new Goods();

        if(null!=cid&&!cid.equals("")){
            goods.setcId(Integer.parseInt(cid));
        }
        goods.setgTitle(title);
        System.out.println(goods.toString());

      return  ResponseUtil.ok(goodsService.selectByType(goods,pageNum,pageSize));

        //return  ResponseUtil.ok(categoryService.selectAll());
    }
}
