package com.hlb.entity;

/**
 * @author: code_hlb
 * @date :  2023/10/22 11:39
 * @desc :  定义图书的基本属性
 */
public class BookList {

    // 书号ID --> 方便根据 ID 借书  -->  也方便后面JDBC优化时的主键
    private String id;
    // 书名
    private String name;
    // 作者
    private String author;
    // 价格
    private double value;
    // 类别
    public String type;
    // 状态
    private BookStatus status;
    // 借出时间
    private String lendTime;

    public BookList() {
    }

    public BookList(String id, String name, String author, double value, String type, BookStatus status, String lendTime) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.value = value;
        this.type = type;
        this.status = status;
        this.lendTime = lendTime;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public String getLendTime() {
        return lendTime;
    }

    public void setLendTime(String lendTime) {
        this.lendTime = lendTime;
    }

    @Override
    public String toString() {
        return "BookList{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", value=" + value +
                ", type='" + type + '\'' +
                ", status=" + status.getMessage() +
                ", lendTime='" + lendTime + '\'' +
                '}';
    }
}
