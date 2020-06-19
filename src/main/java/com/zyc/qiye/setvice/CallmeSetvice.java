package com.zyc.qiye.setvice;

import com.github.pagehelper.PageInfo;
import com.zyc.qiye.pojo.Callme;

import java.util.List;

public interface CallmeSetvice {

    PageInfo<Callme> select(int pageNum,int pageSize );
    PageInfo<Callme> search(int pageNum,int pageSize,String value);
    Boolean delete(String[] id);

    Boolean insert(String name,String company,String iphone,String info);

}
