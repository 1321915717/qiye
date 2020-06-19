package com.zyc.qiye.setvice;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyc.qiye.dto.CategoryDto;
import com.zyc.qiye.mapper.CategoryMapper;
import com.zyc.qiye.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements  CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public PageInfo<Category> selectOne(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        return new PageInfo<>(categoryMapper.selectOne());
    }

    @Override
    public Category selectbyCid(int cid) {
      return   categoryMapper.selectByCid(cid);

    }

    @Override
    public List selectTwo(int pid) {


        return categoryMapper.selectTwo(pid);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insertTwo(Category category) {

        try {
            int code = categoryMapper.insertTwo(category);
            if (code > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(int cid) {
        try {


            int code = categoryMapper.delete(cid);
            if (code > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean update(Category category) {
        try {
            int code = categoryMapper.update(category);
            if (code > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }


    @Override
    public List selectAll() {


        List<CategoryDto> categoryDtoList = new ArrayList<>();
        List<Category> list = categoryMapper.select();
        for (Category category : list) {
            if (category.getcPid() == -1) {
                CategoryDto categoryDto = new CategoryDto();
                categoryDto.setId(category.getcId());
                categoryDto.setName(category.getcName());
                categoryDto.setPid(category.getcPid());
                long count= list.stream().filter(categorys -> categorys.getcPid().equals(category.getcId())).count();
             if(count!=0){
                 categoryDto.setChildren(categoryList(category.getcId(), list));

             }
                categoryDtoList.add(categoryDto);
            }
        }

        return categoryDtoList;
    }

    @Override
    public List selectByOneCategory() {
        return categoryMapper.selectByOneCategory();
    }

    @Override
    public List selectTwoByPid(int pid) {
        return categoryMapper.selectTwoByPid(pid);
    }

    @Override
    public List selectAllE() {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        List<Category> list = categoryMapper.select();
        for (Category category : list) {
            if (category.getcPid() == -1) {
                CategoryDto categoryDto = new CategoryDto();
                categoryDto.setId(category.getcId());
                categoryDto.setName(category.getcEname());
                categoryDto.setPid(category.getcPid());
                long count= list.stream().filter(categorys -> categorys.getcPid().equals(category.getcId())).count();
                if(count!=0){
                    categoryDto.setChildren(categoryListE(category.getcId(), list));

                }
                categoryDtoList.add(categoryDto);
            }
        }

        return categoryDtoList;
    }

    @Override
    public List<CategoryDto> categoryList(int cid, List<Category> list) {
        List<CategoryDto> categoryDtoList = new ArrayList<>();

        for (Category category : list) {
            if (category.getcPid() == cid ) {
                CategoryDto categoryDto = new CategoryDto();
                categoryDto.setId(category.getcId());
                categoryDto.setName(category.getcName());
                categoryDto.setPid(category.getcPid());
                long count= list.stream().filter(categorys -> categorys.getcPid().equals(category.getcId())).count();
                if(count!=0){
                    categoryDto.setChildren(categoryList(category.getcId(), list));

                }
                categoryDtoList.add(categoryDto);
            }

        }
        return categoryDtoList;

    }

    @Override
    public List<CategoryDto> categoryListE(int pid, List<Category> list) {
        List<CategoryDto> categoryDtoList = new ArrayList<>();

        for (Category category : list) {
            if (category.getcPid() == pid ) {
                CategoryDto categoryDto = new CategoryDto();
                categoryDto.setId(category.getcId());
                categoryDto.setName(category.getcEname());
                categoryDto.setPid(category.getcPid());
                long count= list.stream().filter(categorys -> categorys.getcPid().equals(category.getcId())).count();
                if(count!=0){
                    categoryDto.setChildren(categoryListE(category.getcId(), list));

                }
                categoryDtoList.add(categoryDto);
            }

        }
        return categoryDtoList;
    }
}
