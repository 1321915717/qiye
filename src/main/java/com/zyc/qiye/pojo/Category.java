package com.zyc.qiye.pojo;

public class Category {

    private  Integer cId;
    private  String cName;
    private  Integer cPid;
    private  String cEname;
    private  String cImg;

    public String getcImg() {
        return cImg;
    }

    public void setcImg(String cImg) {
        this.cImg = cImg;
    }

    public String getcEname() {
        return cEname;
    }

    public void setcEname(String cEname) {
        this.cEname = cEname;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cPid=" + cPid +
                '}';
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Integer getcPid() {
        return cPid;
    }

    public void setcPid(Integer cPid) {
        this.cPid = cPid;
    }
}
