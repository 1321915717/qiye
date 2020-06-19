package com.zyc.qiye.admincontroller;


import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zyc.qiye.dto.LunboDto;
import com.zyc.qiye.pojo.Introduce;
import com.zyc.qiye.pojo.Lunbo;
import com.zyc.qiye.setvice.IntroduceService;
import com.zyc.qiye.setvice.LunboService;
import com.zyc.qiye.util.ResponseUtil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequestMapping("/admin/info")
@RestController
public class InfoController {

    @Autowired
    private LunboService lunboService;

    @Autowired
    private IntroduceService introduceService;

    @RequestMapping("findLun")
    public  Object findLun(){

        return ResponseUtil.ok(lunboService.select());


    }

    @RequestMapping("findIntroduce")

    public  Object findIntroduce(){


        return  ResponseUtil.ok(introduceService.select());
    }
    @RequestMapping("introduce")
    public  Object introduce(
            @RequestBody String content

            ){
        JSONObject jsonObject = JSONObject.parseObject(content);
      String contents=  jsonObject.get("content").toString();
      String type=jsonObject.get("type").toString();

                Boolean b=introduceService.update(contents,type);

                if(b){
                    return  ResponseUtil.ok();
                }
            return  ResponseUtil.fail();

    }


    @RequestMapping("updateInfo")
    public Object  updateInfo(
            @RequestBody String lunbo
            ){


        String json=lunbo.substring(9);
        json=json.substring(0,json.lastIndexOf("}"));

        List<Lunbo> gameList = JSONObject.parseArray(json, Lunbo.class);

       Boolean b= lunboService.updateLun(gameList);
     if(b){
         return  ResponseUtil.ok();
     }
        return  ResponseUtil.fail();





    }
}
