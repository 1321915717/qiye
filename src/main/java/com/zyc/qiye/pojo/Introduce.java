package com.zyc.qiye.pojo;

public class Introduce {
    private  Integer id;
    private  String introduce;
    private  String eintroduce;
    private   String calls;
    private  String  ecall;

    public String getCalls() {
        return calls;
    }

    public void setCalls(String calls) {
        this.calls = calls;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getEintroduce() {
        return eintroduce;
    }

    public void setEintroduce(String eintroduce) {
        this.eintroduce = eintroduce;
    }



    public String getEcall() {
        return ecall;
    }

    public void setEcall(String ecall) {
        this.ecall = ecall;
    }

    @Override
    public String toString() {
        return "Introduce{" +
                "id=" + id +
                ", introduce='" + introduce + '\'' +
                ", eintroduce='" + eintroduce + '\'' +
                ", call='" + calls + '\'' +
                ", ecall='" + ecall + '\'' +
                '}';
    }
}
