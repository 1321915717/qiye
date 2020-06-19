package com.zyc.qiye.setvice;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyc.qiye.mapper.GoodsMapper;
import com.zyc.qiye.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GoodsServiceImpl implements  GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public PageInfo<Goods> select(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);


        return new PageInfo<>(goodsMapper.select());
    }

    @Override
    public Boolean insert(String video, String lun, String img, String title, String content, int cid, String type) {
      Goods goods =new Goods();
      goods.setgVideo(video);
      goods.setgLun(lun);
      goods.setgImg(img);
      goods.setgTitle(title);
      goods.setgContent(content);
      goods.setcId(cid);
      goods.setgDate(new Date());
      goods.setgType(type);
     int code= goodsMapper.insert(goods);

        if(code>0){
            return  true;
        }
     return false;
    }

    @Override
    public Boolean update(Goods goods) {
      int code= goodsMapper.update(goods);
      if(code>0){
          return  true;
      }
      return false;
    }

    @Override
    public Boolean delete(int id) {
        int code=goodsMapper.delete(id);
        if(code>0){
            return  true;
        }
        return false;
    }

    @Override
    public PageInfo<Goods> selectByType(Goods goods, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(goodsMapper.selectByType(goods));
    }

    @Override
    public List selectByTypeTop(String type) {
        return goodsMapper.selectByTypeTop(type);
    }

    @Override
    public PageInfo<Goods> selectByCAndCid(Goods goods,int pageNum,int pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(goodsMapper.selectByCAndCid(goods));
    }

    @Override
    public Goods selectByGid(int id) {
        return goodsMapper.selectByGid(id);
    }

    @Override
    public List selectByName(String name,String type) {
        return goodsMapper.selectByName(name,type);
    }
}
