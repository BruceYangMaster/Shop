package com.deepblue.shop.Business.Model;

/**
 * Created by 欢大哥 on 2016/6/7.
 */
public class User {
    private String userName;   //名字
    private String userAddress;   //地址
    private String userPhone;     //电话

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
