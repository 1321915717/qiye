package com.zyc.qiye.setvice;

import com.zyc.qiye.pojo.Lunbo;

import java.util.List;

public interface LunboService {

    List select();

     Boolean   updateLun(List list);
    List selectByImage();
     Lunbo  selectByVideo();
}
