package com.zyc.qiye.pojo;

import java.util.Date;

public class Goods {

    private  Integer gId;
    private  String gVideo;
    private  String gLun;
    private  String gImg;
    private  String gTitle;
    private  String gContent;
    private Date  gDate;
    private  Integer cId;
    private  Category category;
    private  String gType;

    @Override
    public String toString() {
        return "Goods{" +
                "gId=" + gId +
                ", gVideo='" + gVideo + '\'' +
                ", gLun='" + gLun + '\'' +
                ", gImg='" + gImg + '\'' +
                ", gTitle='" + gTitle + '\'' +
                ", gContent='" + gContent + '\'' +
                ", gDate=" + gDate +
                ", cId=" + cId +
                ", category=" + category +
                ", gType='" + gType + '\'' +
                '}';
    }

    public String getgType() {
        return gType;
    }

    public void setgType(String gType) {
        this.gType = gType;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public String getgVideo() {
        return gVideo;
    }

    public void setgVideo(String gVideo) {
        this.gVideo = gVideo;
    }

    public String getgLun() {
        return gLun;
    }

    public void setgLun(String gLun) {
        this.gLun = gLun;
    }

    public String getgImg() {
        return gImg;
    }

    public void setgImg(String gImg) {
        this.gImg = gImg;
    }

    public String getgTitle() {
        return gTitle;
    }

    public void setgTitle(String gTitle) {
        this.gTitle = gTitle;
    }

    public String getgContent() {
        return gContent;
    }

    public void setgContent(String gContent) {
        this.gContent = gContent;
    }

    public Date getgDate() {
        return gDate;
    }

    public void setgDate(Date gDate) {
        this.gDate = gDate;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
