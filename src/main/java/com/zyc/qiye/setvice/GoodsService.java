package com.zyc.qiye.setvice;

import com.github.pagehelper.PageInfo;
import com.zyc.qiye.pojo.Goods;

import java.util.List;

public interface GoodsService {

    PageInfo<Goods> select(int pageNum,int pageSize);
    Boolean insert(String video,String lun,String img,String title,String content,int cid,String type);
    Boolean update(Goods goods);
    Boolean delete(int id);

    PageInfo<Goods> selectByType(Goods goods,int pageNum,int pageSize);
    List selectByTypeTop(String type);

    PageInfo<Goods> selectByCAndCid(Goods goods,int pageNum,int pageSize);
    Goods selectByGid(int id);

    List selectByName(String name,String type);
}
