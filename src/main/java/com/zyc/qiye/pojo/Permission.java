package com.zyc.qiye.pojo;

public class Permission {
    private  Integer pId;
    private  String pName;
    private  String pUrl;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpUrl() {
        return pUrl;
    }

    public void setpUrl(String pUrl) {
        this.pUrl = pUrl;
    }

    public static class Category {

        private  Integer cId;


        public Integer getcId() {
            return cId;
        }

        public void setcId(Integer cId) {
            this.cId = cId;
        }

        private  Integer cOrder;


        public Integer getcOrder() {
            return cOrder;
        }

        public void setcOrder(Integer cOrder) {
            this.cOrder = cOrder;
        }












    }
}
