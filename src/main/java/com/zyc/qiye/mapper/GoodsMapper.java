package com.zyc.qiye.mapper;

import com.zyc.qiye.pojo.Category;
import com.zyc.qiye.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

    List select();
    int insert(Goods goods);
    int update(Goods goods);
    int delete(int id);
    List selectByType(Goods goods);
    int  selectById(int id);
    List  selectByTypeTop(String type);
    List selectByCAndCid(Goods goods);
    Goods selectByGid(int id);

    List selectByName(@Param("name") String name,@Param("type")String type);

}
