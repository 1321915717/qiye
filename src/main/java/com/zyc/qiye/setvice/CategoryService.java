package com.zyc.qiye.setvice;

import com.github.pagehelper.PageInfo;
import com.zyc.qiye.dto.CategoryDto;
import com.zyc.qiye.pojo.Category;
import org.w3c.dom.ls.LSInput;

import java.util.List;

public interface CategoryService {

   PageInfo<Category> selectOne(int pageNum,int pageSize);
     Category selectbyCid(int cid);
    List selectTwo(int pid);
    Boolean  insertTwo(Category category);
    Boolean delete(int cid);
    Boolean  update(Category category);
     List selectAll();
    List selectByOneCategory();

    List selectTwoByPid(int pid);
    List selectAllE();
     List<CategoryDto> categoryList(int pid, List<Category> list);
    List<CategoryDto> categoryListE(int pid, List<Category> list);


}
