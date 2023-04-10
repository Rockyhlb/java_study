package com.hlb.enums;

public enum DvdStatus {
    INSTORE(0,"在店"),
    OUTSTORE(1,"出租"),
    BADDISK(2,"坏碟"),
    SUBSCRIPT(3,"预定")
    ;

    int code;
    String message;

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

    DvdStatus(int code, String message){
        this.code = code;
        this.message = message;
    }
}
