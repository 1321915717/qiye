package com.zyc.qiye.pojo;

import java.util.Date;

public class Callme {

    private Integer cId;
    private  String cName;
    private  String cCompany;
    private  String cIphone;
    private  String cInfo;
    private Date cDate;

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

    public String getcCompany() {
        return cCompany;
    }

    public void setcCompany(String cCompany) {
        this.cCompany = cCompany;
    }

    public String getcIphone() {
        return cIphone;
    }

    public void setcIphone(String cIphone) {
        this.cIphone = cIphone;
    }

    public String getcInfo() {
        return cInfo;
    }

    public void setcInfo(String cInfo) {
        this.cInfo = cInfo;
    }

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    @Override
    public String toString() {
        return "Callme{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cCompany='" + cCompany + '\'' +
                ", cIphone='" + cIphone + '\'' +
                ", cInfo='" + cInfo + '\'' +
                ", cDate=" + cDate +
                '}';
    }
}
