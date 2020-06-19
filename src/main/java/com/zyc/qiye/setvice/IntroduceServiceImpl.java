package com.zyc.qiye.setvice;

import com.zyc.qiye.mapper.IntroduceMapper;
import com.zyc.qiye.pojo.Introduce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntroduceServiceImpl implements  IntroduceService {

    @Autowired
    private IntroduceMapper introduceMapper;

    @Override
    public Boolean update(String content, String type) {
        int code=0;
        if(type.equals("introduce")){
                code=introduceMapper.insertIntroduce(content);


            }else if(type.equals("eintroduce")){
            code=introduceMapper.insertEIntroduce(content);

            }else if(type.equals("call")){
            code=introduceMapper.insertCall(content);

            }else  if(type.equals("ecall")){
            code=introduceMapper.insertECall(content);

            }
                if(code!=0){
                    return  true;
                }
        return false;
    }

    @Override
    public Introduce select() {

        return introduceMapper.select();
    }
}
