package com.meal.bean;

/**
 * @author xiamingxing
 *
 */
public class Menu {

    private Long mid;

    private double discount;

    private double price;

    private String name;

    private String photo;

    private Long sid;

    private Menu() {

    }

    public Menu(String name, String photo, double price, double discount) {

        this.mid = -1l;

        this.name = name;

        this.photo = (null != photo) ? photo : Constant.MENU_PHOTO_DEFAULT_URL;

        this.price = price;

        this.discount = discount;

        this.sid = (null != Global.seller) ? Global.seller.getSid() : -1l;

    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

}
