package com.zyc.qiye.pojo;

import java.util.Date;

public class News {
    private  Integer nId;
    private String nTitle;
    private Date nDate;
    private  String nContent;
    private  String nImg;
    private  String nType;

    public String getnImg() {
        return nImg;
    }

    public void setnImg(String nImg) {
        this.nImg = nImg;
    }

    public String getnType() {
        return nType;
    }

    public void setnType(String nType) {
        this.nType = nType;
    }

    public Integer getnId() {
        return nId;
    }

    public void setnId(Integer nId) {
        this.nId = nId;
    }

    public String getnTitle() {
        return nTitle;
    }

    public void setnTitle(String nTitle) {
        this.nTitle = nTitle;
    }

    public Date getnDate() {
        return nDate;
    }

    public void setnDate(Date nDate) {
        this.nDate = nDate;
    }

    public String getnContent() {
        return nContent;
    }

    public void setnContent(String nContent) {
        this.nContent = nContent;
    }
}
