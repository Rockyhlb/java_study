package com.hlb.entity;

/**
 * @author: code_hlb
 * @date :  2023/10/22 11:39
 * @desc :  利用枚举类型定义图书的状态
 */
public enum  BookStatus {
    FREE(1,"在馆"),
    BORROWED(2,"借出"),
    RESERVATION(3,"预定")
    ;

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    BookStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
