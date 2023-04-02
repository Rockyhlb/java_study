package com.hlb;

public enum DvdStatus {
    INSTORE(0,"在店"),
    OUTSTORE(1,"出租"),
    BADDISK(2,"坏碟"),
    SUBSCRIPT(3,"预定")
    ;

    int code;
    String message;

    DvdStatus(int code,String message){
        this.code = code;
        this.message = message;
    }
}
