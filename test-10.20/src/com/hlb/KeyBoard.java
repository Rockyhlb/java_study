package com.hlb;

/**
 * @author: code_hlb
 * @date : 2023/10/20 10:55
 */
public class KeyBoard implements Device {

    public String name = "keyBoard";

    @Override
    public void connect() {
        System.out.println(name + " 正在连接");
    }

    @Override
    public void disconnect() {
        System.out.println(name + " 断开连接");
    }
}
