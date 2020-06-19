package com.zyc.qiye.admincontroller;


import com.zyc.qiye.dto.CategoryHashMap;
import com.zyc.qiye.mapper.CategoryMapper;
import com.zyc.qiye.mapper.GoodsMapper;
import com.zyc.qiye.pojo.Category;
import com.zyc.qiye.setvice.CategoryService;
import com.zyc.qiye.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private GoodsMapper goodsMapper;




    @RequestMapping("/selectOne")
    public  Object selectOne(
            @RequestParam("pageNum")int pageNum,
            @RequestParam("pageSize")int pageSize
    ){


        return ResponseUtil.ok(categoryService.selectOne(pageNum,pageSize));

    }
    @RequestMapping("/selectTwo")
    public  Object selectOne(
            @RequestParam("pid")int pid

    ){


        return ResponseUtil.ok(categoryService.selectTwo(pid));

    }

    @RequestMapping("/insertCategory")
    public  Object selectOne(
            @RequestParam("pid")int pid,
            @RequestParam("name") String name,
            @RequestParam("ename")String ename,
            @RequestParam("img")String img

    ){

        Category category =new Category();
        category.setcPid(pid);
        category.setcEname(ename);
        category.setcName(name);
        category.setcImg(img);
       Boolean b= categoryService.insertTwo(category);
        if(b){
            return ResponseUtil.ok();
        }
        return  ResponseUtil.fail();

    }
    @RequestMapping("/updateCategory")
    public  Object updateCategory(
            @RequestParam("cid")int cid,
            @RequestParam("name") String name,
            @RequestParam("ename")String ename,
            @RequestParam(name = "img",required = false)String img

    ){


        Category category =new Category();
       category.setcId(cid);
        category.setcEname(ename);
        category.setcName(name);
        if(null!=img){
            category.setcImg(img);
        }
        Boolean b= categoryService.update(category);
        if(b){
            return ResponseUtil.ok();
        }
        return  ResponseUtil.fail();

    }

    @RequestMapping("/deleteCategory")
    public  Object deleteCategory(
            @RequestParam("cid")int id


    ){
        List list= categoryService.selectTwo(id);


        if(list.size()!=0){
            return  ResponseUtil.fail(-2,"分类下还有子分类,无法删除");

        }
       int count= goodsMapper.selectById(id);

        if(count>0){
            return  ResponseUtil.fail(-3,"分类下还有商品,无法删除");
        }
        Boolean b= categoryService.delete(id);
        if(b){
            return ResponseUtil.ok();
        }
        return  ResponseUtil.fail();





    }

    @RequestMapping("findAll")
    public  Object findAll(){

        List<Category> list = categoryMapper.select();

        return  ResponseUtil.ok(new CategoryHashMap().result(list));

        //return  ResponseUtil.ok(categoryService.selectAll());
    }


    @RequestMapping("findByCid")
    public  Object findByCid(
            @RequestParam("cid")int cid
    ){



        return  ResponseUtil.ok(categoryService.selectbyCid(cid));

        //return  ResponseUtil.ok(categoryService.selectAll());
    }

}
