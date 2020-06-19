package com.zyc.qiye.setvice;

import com.zyc.qiye.pojo.Introduce;

public interface IntroduceService {

    Boolean update(String content,String type);
    Introduce select();
}
