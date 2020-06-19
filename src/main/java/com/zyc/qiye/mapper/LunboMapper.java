package com.zyc.qiye.mapper;

import com.zyc.qiye.pojo.Lunbo;

import java.util.List;

public interface LunboMapper {
    List select();

    void delete();
   void insert(List list);
    List selectByImage();
    Lunbo selectByVideo();
}
