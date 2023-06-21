package com.zy.entity;

import java.time.LocalDate;

public class order_zhouyue {

    String goods_id;
    String name;
    String type;
    float price;
    int num;
    LocalDate sell_time;

    public order_zhouyue() {
    }

    public order_zhouyue(String goods_id, String name, String type, float price, int num, LocalDate sell_time) {
        this.goods_id = goods_id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.num = num;
        this.sell_time = sell_time;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public LocalDate getSell_time() {
        return sell_time;
    }

    public void setSell_time(LocalDate sell_time) {
        this.sell_time = sell_time;
    }
}


