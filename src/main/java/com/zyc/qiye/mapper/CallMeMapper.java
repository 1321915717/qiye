package com.zyc.qiye.mapper;

import com.zyc.qiye.pojo.Callme;

import java.util.List;

public interface CallMeMapper {

    List select();
    List search(String value);
   void   delete(String[] ids);
    void   insert(Callme callme);
}
