package com.zyc.qiye.mapper;

import com.zyc.qiye.pojo.Introduce;

public interface IntroduceMapper {

    int  insertIntroduce(String content);
    int  insertEIntroduce(String content);
    int  insertCall(String content);
    int  insertECall(String content);
    Introduce select();
}
