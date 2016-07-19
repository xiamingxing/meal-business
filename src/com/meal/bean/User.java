package com.meal.bean;

import java.util.ArrayList;

/**
 * @author xiamingxing
 *
 */
public class User {

    private Long uid;

    private String name;

    private String passWord;

    private String portrait;

    private String phone;

    private String address;

    private ArrayList<Long> orderList;

    private ArrayList<Long> messageList;

    private User() {

    }

    public User(String name, String passWord, String portrait,
                String phone, String address) {

        this.uid = -1l;

        this.name = name;

        this.passWord = passWord;

        this.portrait = (null != portrait) ? portrait : Constant.USER_PORTRAIT_DEFAULT_URL;

        this.phone = phone;

        this.address = address;

        this.orderList = null;

        this.messageList = null;

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Long> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Long> orderList) {
        this.orderList = orderList;
    }

    public ArrayList<Long> getMessageList() {
        return messageList;
    }

    public void setMessageList(ArrayList<Long> messageList) {
        this.messageList = messageList;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

}
