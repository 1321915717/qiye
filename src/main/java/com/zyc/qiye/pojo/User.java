package com.zyc.qiye.pojo;

import java.util.Date;
import java.util.List;

public class User {

    private  Integer uId;
    private  String userName;
    private  String password;
    private Date uLoginDate;
    private  Date uCreateDate;
    private List<Role> roleList;

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getuLoginDate() {
        return uLoginDate;
    }

    public void setuLoginDate(Date uLoginDate) {
        this.uLoginDate = uLoginDate;
    }

    public Date getuCreateDate() {
        return uCreateDate;
    }

    public void setuCreateDate(Date uCreateDate) {
        this.uCreateDate = uCreateDate;
    }
}
