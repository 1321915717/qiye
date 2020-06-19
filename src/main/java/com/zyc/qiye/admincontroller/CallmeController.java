package com.zyc.qiye.admincontroller;

import com.github.pagehelper.PageInfo;
import com.zyc.qiye.pojo.Callme;
import com.zyc.qiye.setvice.CallmeSetvice;
import com.zyc.qiye.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/admin/callMe")
public class CallmeController {

    @Autowired
    private CallmeSetvice callmeSetvice;

    @RequestMapping("/findAll")
    public  Object selectAll(
            @RequestParam("pageNum")int pageNum,
            @RequestParam("pageSize")int pageSize
    ){
       PageInfo<Callme> pageInfo= callmeSetvice.select(pageNum,pageSize);
        if(null!=pageInfo){
            return ResponseUtil.ok(pageInfo);
        }
        return  ResponseUtil.fail(-1,"数据为空");
    }

    @RequestMapping("/search")
    public  Object search(
            @RequestParam("pageNum")int pageNum,
            @RequestParam("pageSize")int pageSize,
            @RequestParam("value")String value
    ){
        PageInfo<Callme> pageInfo= callmeSetvice.search(pageNum,pageSize,value);
        if(null!=pageInfo){
            return ResponseUtil.ok(pageInfo);
        }
        return  ResponseUtil.fail(-1,"数据为空");
    }

    @RequestMapping("delete")
    public  Object delete(
            @RequestParam("ids") String id
    ){

        String [] ids=null;
        if(id.length()==1){
          ids=new String[]{id};


        }else {
          ids=   StringUtils.delimitedListToStringArray(id,",");

        }
        if(null==ids){
            return  ResponseUtil.fail();
        }
        Boolean b= callmeSetvice.delete(ids);
        if(b){
            return  ResponseUtil.ok();
        }
        return  ResponseUtil.fail();



    }
}
