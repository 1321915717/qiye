package com.zyc.qiye.dto;

import com.zyc.qiye.pojo.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class CategoryHashMap {



    public HashMap<String,Object> result(List<Category> list){

        HashMap<String,Object> hashMap = new HashMap<>();

        ArrayList<Object> arrayList = new ArrayList<>();

        for (Category item: list) {
            HashMap<String,Object> hashMapNext = new HashMap<>();
            if (item.getcPid() == -1) { // 一级目录
                hashMapNext.put("value",item.getcId());
                hashMapNext.put("label",item.getcName());

                long count= list.stream().filter(category -> category.getcPid().equals(item.getcId())).count();
            if(count!=0){
                hashMapNext.put("children",this.next(item.getcId(),list));
            }

                arrayList.add(hashMapNext);
            }
        }
        hashMap.put("options",arrayList);
        return hashMap;


    }

    // // 子级目录
    public List<Object> next(Integer cid,List<Category> list){
        ArrayList<Object> arrayList = new ArrayList<>();
        ArrayList<Object> arrayListNext = new ArrayList<>();
        for (Category item: list) {
            HashMap<String,Object> hashMap = new HashMap<>();

            if (item.getcPid() == cid) { // 二级目录
                hashMap.put("value",item.getcId());
                hashMap.put("label",item.getcName());

                int id= 0;
                for (Category itemNext: list) {  // 三级结构
                    HashMap<String,Object> hashMapNaxt = new HashMap<>();
                    if (item.getcId() == itemNext.getcPid()){
                        id = itemNext.getcPid();
                        hashMapNaxt.put("value",itemNext.getcId());
                        hashMapNaxt.put("label",itemNext.getcName());
                        arrayListNext.add(hashMapNaxt);
                    }
                }
                if (arrayListNext.size() > 0 && item.getcId() == id) {
                    hashMap.put("children",arrayListNext);
                }
                arrayList.add(hashMap);
            }

        }
        return arrayList;
    }


}
