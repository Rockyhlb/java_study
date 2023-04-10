package com.hlb.entity;

import com.hlb.enums.DvdStatus;

public class Dvd {
    String id;          //编号
    String name;        //名称
    double cost;        //日租金
    String borrow_date; //出租日期
    String return_date; //归还日期
    DvdStatus status;   //状态
    int sum_times;      //出租次数

    double profit;      //收益
    double maxProfit;   //最大边际利润

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(String borrow_date) {
        this.borrow_date = borrow_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public DvdStatus getStatus() {
        return status;
    }

    public void setStatus(DvdStatus status) {
        this.status = status;
    }

    public int getSum_times() {
        return sum_times;
    }

    public void setSum_times(int sum_times) {
        this.sum_times = sum_times;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getMaxProfit() {
        return maxProfit;
    }

    public void setMaxProfit(double maxProfit) {
        this.maxProfit = maxProfit;
    }

    public Dvd() {}

    public Dvd(String id, String name, double cost, String borrow_date, String return_date,
               DvdStatus status, int sum_times, double profit, double maxProfit) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.borrow_date = borrow_date;
        this.return_date = return_date;
        this.status = status;
        this.sum_times = sum_times;
        this.profit = profit;
        this.maxProfit = maxProfit;
    }

    @Override
    public String toString() {
        return "Dvd{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", borrowDate='" + borrow_date + '\'' +
                ", returnDate='" + return_date + '\'' +
//                ", status=" + status +
                ", sum_times=" + sum_times +
                ", profit=" + profit +
                '}';
    }
}
