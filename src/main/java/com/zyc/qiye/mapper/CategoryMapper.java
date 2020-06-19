package com.zyc.qiye.mapper;

import com.zyc.qiye.pojo.Category;

import java.util.List;

public interface CategoryMapper {


    List select();
    List selectByOneCategory();
    List selectTwoLimit();
   List  selectTwoByPid(int pid);
    List selectOne();
    List selectTwo(int pid);
    int  insertTwo(Category category);
    int delete(int cid);
    int   update(Category category);
   Category  selectByCid(int cid);

}
