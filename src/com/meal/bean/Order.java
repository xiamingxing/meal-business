package com.meal.bean;

import com.meal.util.SysUtil;

import java.util.ArrayList;

/**
 * @author xiamingxing
 *
 */
public class Order {

    private Long oid;

    private String status;

    private ArrayList<Long> menuList;

    private String time;

    private short score;

    private double pay;

    private String address;

    private String phone;

    private Long uid;

    private Order() {

    }

    public Order(String phone, String address, double pay,
                 ArrayList<Long> menuList) {

        this.oid = -1l;

        this.status = null;

        this.menuList = menuList;

        this.time = SysUtil.getTime();

        this.score = 0;

        this.pay = pay;

        this.address = address;

        this.phone = phone;

        this.setUid((null != Global.user) ? Global.user.getUid() : -1l);

    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Long> getMenuList() {
        return menuList;
    }

    public void setMenuList(ArrayList<Long> menuList) {
        this.menuList = menuList;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public short getScore() {
        return score;
    }

    public void setScore(short score) {
        this.score = score;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

}
