package com.hlb;

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

    @Override
    public String toString() {
        return "Dvd{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", borrowDate='" + borrow_date + '\'' +
                ", returnDate='" + return_date + '\'' +
                ", status=" + status.message +
                ", sum_times=" + sum_times +
                ", profit=" + profit +
                '}';
    }
}
