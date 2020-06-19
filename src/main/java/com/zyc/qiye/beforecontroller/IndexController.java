package com.zyc.qiye.beforecontroller;


import com.zyc.qiye.dto.CategoryDto;
import com.zyc.qiye.mapper.CategoryMapper;
import com.zyc.qiye.mapper.NewsMapper;
import com.zyc.qiye.pojo.Category;
import com.zyc.qiye.pojo.Goods;
import com.zyc.qiye.pojo.Introduce;
import com.zyc.qiye.setvice.*;
import com.zyc.qiye.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/wx/index")
public class IndexController {

    @Autowired
    private LunboService lunboService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private NewsSetvice newsSetvice;

    @Autowired
    private NewsMapper newsMapper;
    @Autowired
    private CallmeSetvice callmeSetvice;

    @Autowired
    private IntroduceService introduceService;

    @Autowired
    private  CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @RequestMapping("/findLunbo")
    public   Object findLunbo(){
       return ResponseUtil.ok(lunboService.selectByImage());
    }
    @RequestMapping("/findVideo")
    public   Object findVideo(){

        return ResponseUtil.ok(lunboService.selectByVideo());
    }
    @RequestMapping("/findGoods")
    public   Object findGoods(
            @RequestParam("type")String type
    ){

        return ResponseUtil.ok(goodsService.selectByTypeTop(type));
    }
    @RequestMapping("/findNews")
    public  Object findNews(
           @RequestParam("type")String type,
            @RequestParam("pageNum")int pageNum,
             @RequestParam("pageSize")int pageSize
    ){
        return ResponseUtil.ok(newsSetvice.selectByTypeTop(type,pageNum,pageSize));


    }
    @RequestMapping("findNewsById")
    public  Object findNewsById(
            @RequestParam("id")int id
    ){
        return ResponseUtil.ok(newsMapper.selectByNid(id));


    }
    @RequestMapping("insertCallMe")
    public  Object insertCallMe(
            @RequestParam("name")String name,
            @RequestParam("company")String company,
            @RequestParam("iphone")String iphone,
            @RequestParam("info")String info
    ){

        Boolean b=callmeSetvice.insert(name,company,iphone,info);
        if(b){
            return  ResponseUtil.ok();
        }
        return  ResponseUtil.fail();


    }

    @RequestMapping("findIntroduce")
    public  Object findIntroduce(

    ){

        return ResponseUtil.ok(introduceService.select());


    }


    @RequestMapping("findGoodsByCid")
    public  Object findGoodsByCid(
            @RequestParam("cid")int cid,
            @RequestParam("type")String type,
            @RequestParam("pageNum")int pageNum,
            @RequestParam("pageSize")int pageSize

    ){

        Goods goods =new Goods();

        if(cid!=-1){
            goods.setcId(cid);
        }

        goods.setgType(type);

        return ResponseUtil.ok(goodsService.selectByCAndCid(goods,pageNum,pageSize));


    }

    @RequestMapping("findAllCategory")
    public  Object findAllCategory(


    ){


        return  ResponseUtil.ok(categoryMapper.selectTwoLimit());

        /*List oneCategory=new ArrayList();
        List twoCategory=new ArrayList();
        List threeCategory=new ArrayList();
       List<CategoryDto> list1=  categoryService.selectAll();

       for(CategoryDto c1 :list1){
         oneCategory.add(c1);
         if(c1.getChildren()!=null){
             for (CategoryDto c2: c1.getChildren()) {
                 twoCategory.add(c2);
                 if(c2.getChildren()!=null){
                     for (CategoryDto c3: c2.getChildren()){
                         threeCategory.add(c3);
                     }
                 }
                         }
         }

       }
        HashMap hashMap =new HashMap();
       hashMap.put("one",oneCategory);
        hashMap.put("two",twoCategory);
        hashMap.put("three",threeCategory);
       return  ResponseUtil.ok(hashMap);*/

    }
    @RequestMapping("findOneCategory")
    public  Object selectByOneCategory(){
        return  ResponseUtil.ok(categoryService.selectByOneCategory());
    }
    @RequestMapping("findTwoCategory")
    public  Object findTwoCategory(
            @RequestParam("pid")int pid
    ){
        return  ResponseUtil.ok(categoryService.selectTwoByPid(pid));
    }

    @RequestMapping("searchGoods")
    public  Object searchGoods(
            @RequestParam("name")String name,
            @RequestParam("type")String type
    ){
        return  ResponseUtil.ok(goodsService.selectByName(name,type));
    }


    @RequestMapping("findAllCategoryE")
    public  Object findAllCategoryE(


    ){


        List oneCategory=new ArrayList();
        List twoCategory=new ArrayList();
        List threeCategory=new ArrayList();
        List<CategoryDto> list1=  categoryService.selectAllE();

        for(CategoryDto c1 :list1){
            oneCategory.add(c1);
            if(c1.getChildren()!=null){
                for (CategoryDto c2: c1.getChildren()) {
                    twoCategory.add(c2);
                    if(c2.getChildren()!=null){
                        for (CategoryDto c3: c2.getChildren()){
                            threeCategory.add(c3);
                        }
                    }
                }
            }

        }
        HashMap hashMap =new HashMap();
        hashMap.put("one",oneCategory);
        hashMap.put("two",twoCategory);
        hashMap.put("three",threeCategory);
        return  ResponseUtil.ok(hashMap);

    }

    @RequestMapping("findGoodsByGid")
    public  Object  findByGid(
            @RequestParam("id")int id
    ){


        return  ResponseUtil.ok(goodsService.selectByGid(id));
    }
}
