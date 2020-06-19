package com.zyc.qiye.pojo;

public class Lunbo {
    private  Integer gId;
    private  String gUrl;
    private  String gType;

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public String getgUrl() {
        return gUrl;
    }

    public void setgUrl(String gUrl) {
        this.gUrl = gUrl;
    }

    public String getgType() {
        return gType;
    }

    public void setgType(String gType) {
        this.gType = gType;
    }

    @Override
    public String toString() {
        return "Lunbo{" +
                "gId=" + gId +
                ", gUrl='" + gUrl + '\'' +
                ", gType='" + gType + '\'' +
                '}';
    }
}
