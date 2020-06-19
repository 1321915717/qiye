package com.zyc.qiye.setvice;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyc.qiye.mapper.CallMeMapper;
import com.zyc.qiye.pojo.Callme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CallmeServiceImpl implements  CallmeSetvice {

    @Autowired
    private CallMeMapper callMeMapper;
    @Override
    public PageInfo<Callme> select(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum,pageSize);



        return new PageInfo<Callme>(callMeMapper.select());
    }

    @Override
    public PageInfo<Callme> search(int pageNum, int pageSize,String value) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<Callme>(callMeMapper.search(value));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(String[] id) {
        try {
            callMeMapper.delete(id);
            return  true;
        }catch (Exception e){
            System.out.println(e);
            return  false;
        }

    }

    @Override
    public Boolean insert(String name, String company, String iphone, String info) {
        Callme callme =new Callme();
        callme.setcCompany(company);
        callme.setcDate(new Date());
        callme.setcName(name);
      //  System.out.println(new Date());
        callme.setcInfo(info);
        callme.setcIphone(iphone);


        try {
            callMeMapper.insert(callme);
            return  true;
        }catch (Exception e){
            return  false;
        }

    }
}
