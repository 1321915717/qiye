package com.zyc.qiye.setvice;

import com.zyc.qiye.mapper.LunboMapper;
import com.zyc.qiye.pojo.Lunbo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LunboServiceImpl implements  LunboService {

    @Autowired
    private LunboMapper lunboMapper;

    @Override
    public List select() {
        return lunboMapper.select();


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateLun(List list) {

       try {
           lunboMapper.delete();
           lunboMapper.insert(list);


       }catch (Exception e){
           System.out.println(e);
           return  false;
       }

        return true;
    }

    @Override
    public List selectByImage() {
        return lunboMapper.selectByImage();
    }

    @Override
    public Lunbo selectByVideo() {

        return lunboMapper.selectByVideo();
    }
}
